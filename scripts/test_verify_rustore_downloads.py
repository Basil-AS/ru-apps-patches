import hashlib
import json
import tempfile
import unittest
from pathlib import Path

from verify_rustore_downloads import MatrixError, load_matrix, verify_download


class VerifyRustoreDownloadsTests(unittest.TestCase):
    def write_matrix(self, directory: Path, content: str) -> Path:
        path = directory / "matrix.tsv"
        path.write_text(content, encoding="utf-8")
        return path

    def test_rejects_missing_required_column(self):
        with tempfile.TemporaryDirectory() as tmp:
            path = self.write_matrix(
                Path(tmp),
                "package\tapp_name\tsource_version\tsplit_set\tsha256\n"
                "com.example\tExample\t1\tbase\t" + "0" * 64 + "\n",
            )

            with self.assertRaisesRegex(MatrixError, "acquisition_status"):
                load_matrix(path)

    def test_rejects_duplicate_packages(self):
        row = "com.example\tExample\t1\tbase\t" + "0" * 64 + "\tverified\n"
        with tempfile.TemporaryDirectory() as tmp:
            path = self.write_matrix(
                Path(tmp),
                "package\tapp_name\tsource_version\tsplit_set\tsha256\tacquisition_status\n"
                + row
                + row,
            )

            with self.assertRaisesRegex(MatrixError, "duplicate package"):
                load_matrix(path)

    def test_verifies_sha256_for_downloader_output(self):
        with tempfile.TemporaryDirectory() as tmp:
            root = Path(tmp)
            apk = root / "com.example" / "example.apk"
            apk.parent.mkdir()
            apk.write_bytes(b"not-an-executable-apk-fixture")
            digest = hashlib.sha256(apk.read_bytes()).hexdigest()
            (apk.parent / "info.json").write_text(
                json.dumps({"packageName": "com.example", "versionName": "1.2.3"}),
                encoding="utf-8",
            )
            row = {
                "package": "com.example",
                "app_name": "Example",
                "source_version": "1.2.3",
                "split_set": "example",
                "sha256": digest,
                "acquisition_status": "verified",
            }

            evidence = verify_download(row, root)

            self.assertEqual(evidence["package"], "com.example")
            self.assertEqual(evidence["sha256"], digest)
            self.assertEqual(evidence["apk_files"], ["example.apk"])

    def test_rejects_sha256_mismatch(self):
        with tempfile.TemporaryDirectory() as tmp:
            root = Path(tmp)
            apk = root / "com.example" / "example.apk"
            apk.parent.mkdir()
            apk.write_bytes(b"changed")
            (apk.parent / "info.json").write_text(
                json.dumps({"packageName": "com.example"}), encoding="utf-8"
            )
            row = {
                "package": "com.example",
                "app_name": "Example",
                "source_version": "1.2.3",
                "split_set": "base",
                "sha256": "0" * 64,
                "acquisition_status": "verified",
            }

            with self.assertRaisesRegex(MatrixError, "sha256 mismatch"):
                verify_download(row, root)


if __name__ == "__main__":
    unittest.main()
