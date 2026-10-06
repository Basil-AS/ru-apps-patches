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
            AppTarget(
                version = "19.31.0",
                versionCode = 2706,
                minSdk = 26,
            ),
        ),
    )
}
