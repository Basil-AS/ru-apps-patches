// Ported from Freeman022026/rustore-privacy-patches (GPLv3), dev/freeman022026/rustore/patches/Constants.kt.
package app.ru_apps.rustore

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

const val AUDITED_VERSION = "1.109.1.0"

private const val OFFICIAL_SIGNER_SHA256 =
    "661f20828ef780de0b79bc59f26a30864316355f30e4f91cfa14a20791839914"

object Constants {
    val COMPATIBILITY_RUSTORE = Compatibility(
        name = "RuStore",
        packageName = "ru.vk.store",
        apkFileType = ApkFileType.APK,
        appIconColor = 0x0A85FF,
        signatures = setOf(OFFICIAL_SIGNER_SHA256),
        targets = listOf(
            AppTarget(version = AUDITED_VERSION)
        )
    )
}
