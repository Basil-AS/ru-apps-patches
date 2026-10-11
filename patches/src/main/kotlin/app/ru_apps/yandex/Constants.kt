package app.ru_apps.yandex

import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

/**
 * Compatibility declarations for the requested Yandex applications.
 *
 * Versions are provisional values copied from research/targets.tsv. They are
 * pending a fresh download and package/signature verification; no app-specific
 * fingerprint or bytecode patch is declared here.
 */
object Constants {
    val COMPATIBILITY_YANDEX_MUSIC = Compatibility(
        name = "Yandex Music",
        packageName = "ru.yandex.music",
        targets = listOf(AppTarget(version = "2026.09.4 #166gpr")),
    )

    val COMPATIBILITY_YANDEX_MAPS = Compatibility(
        name = "Yandex Maps",
        packageName = "ru.yandex.yandexmaps",
        targets = listOf(AppTarget(version = "31.0.3")),
    )

    val COMPATIBILITY_YANDEX_TAXI = Compatibility(
        name = "Yandex Go",
        packageName = "ru.yandex.taxi",
        targets = listOf(AppTarget(version = "5.98.0")),
    )

    val COMPATIBILITY_YANDEX_RASP = Compatibility(
        name = "Yandex Rasp",
        packageName = "ru.yandex.rasp",
        targets = listOf(AppTarget(version = "3.73.0")),
    )

    val COMPATIBILITY_YANDEX_MAIL = Compatibility(
        name = "Yandex Mail",
        packageName = "ru.yandex.mail",
        targets = listOf(AppTarget(version = "9.30.0")),
    )
}
