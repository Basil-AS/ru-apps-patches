// Ported from Jl4cTuk/morphe-patches (GPLv3), app/template/patches/ozon/shared/Constants.kt.
package app.ru_apps.ozon_jl4ctuk.shared

import app.morphe.patcher.patch.ApkFileType
import app.morphe.patcher.patch.AppTarget
import app.morphe.patcher.patch.Compatibility

internal object Constants {
    const val PACKAGE_NAME = "ru.ozon.app.android"

    val COMPATIBILITY_OZON_CURRENT = Compatibility(
        name = "Ozon",
        packageName = PACKAGE_NAME,
        apkFileType = ApkFileType.APK,
        appIconColor = 0x005BFF,
        targets = listOf(
            // A single pinned AppTarget meant every patch here was silently
            // skipped against any live Ozon newer than 19.31.0 (same
            // compatibleWith()-gate issue found and fixed for RuStore/RuTube
            // this session). Add the current live version alongside the
            // originally-audited one, following the multi-version AppTarget
            // list convention used elsewhere in this repo.
            AppTarget(
                version = "19.37.0",
                versionCode = 2720,
                minSdk = 26,
            ),
            AppTarget(
                version = "19.31.0",
                versionCode = 2706,
                minSdk = 26,
            ),
        ),
    )
}
