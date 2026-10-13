# RuStore apps: patched APK artifact report (2026-10-14)

## Result and limits

The exact 24-package source matrix was revalidated through the project downloader and all 24 targets were repatched from the verified originals with the current bundle. The runner reported successful PATCHING, REBUILDING and SIGNING steps, no failed patches, and passed per-output SHA-256, `apksigner verify`, package/version/versionCode (`aapt dump badging`) and ZIP checks.

This is static artifact validation, not a claim that all apps launch without errors. An isolated Android 16 emulator could not be brought online: QEMU terminated with SIGSEGV before ADB became available with both SwiftShader and GPU-off modes. Previous smoke results belong to the earlier AppMetrica patch and do not verify these rebuilt outputs.

Eight sources are split APK sets. This run patches only each base APK; those outputs are not complete installable bundles. Every output is signed with the Morphe certificate, not the original RuStore developer certificate, so it cannot update an official installation in place. Do not install financial-app outputs over existing installations.

Artifacts, per-app JSON/logs, `manifest_draft.json` and `batch_report.md` are on the workstation under `/var/mnt/data/ru-apps-patched-20261012/`; APK binaries are not committed to GitHub.

## Patch selection

The run used `--exclusive` with `Disable AppsFlyer`, `Disable analytics libraries`, and `Disable analytics manifest components` for all targets. Sber additionally used `Disable Sberbank advertising ID`; T-Bank additionally used `Disable telemetry worker`. Root/anti-tamper bypasses, spoofing, ad-removal and payment-flow patches were not selected.

## Per-app result and checksum

| Приложение | Package | Версия / versionCode | Что применено | Артефакт | Установочный комплект | SHA-256 patched APK |
|---|---|---|---|---|---|---|
| Яндекс Музыка | `ru.yandex.music` | `2026.09.5 #167.1rur` / `24026502` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.yandex.music.apk` | Один APK; запуск не проверен | `e57ae7128d685509224b200341189ae5c2a3c9945b7d44e32ad07e266f98a2fd` |
| Яндекс Карты | `ru.yandex.yandexmaps` | `31.1.3` / `739706910` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.yandex.yandexmaps.apk` | Один APK; запуск не проверен | `8396043e8ae0258c7ac7898a02a3e9ed691adb77359b7ec38040c9c8b804d9ea` |
| Яндекс Go / Taxi | `ru.yandex.taxi` | `5.98.0` / `30128554` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.yandex.taxi.apk` | Один APK; запуск не проверен | `e64fc7ea1483b49bc799e7f10ce39231059c7b9ee5ad0e36b743cb62c474a266` |
| Яндекс Расписания | `ru.yandex.rasp` | `3.73.0` / `35000063` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.yandex.rasp.apk` | Один APK; запуск не проверен | `55214be05a49af5af2a4bf18482f4b0bd985b0ab8e5595593fb837bd83e9525c` |
| Яндекс Пэй | `com.yandex.bank` | `0.243.0` / `11920` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `com.yandex.bank.apk` | Один APK; запуск не проверен | `9ea47df69f16b6bc927bf46b814f775b1e646b3518b45492cb85761ee79c8d62` |
| СберБанк | `ru.sberbankmobile` | `17.13.0` / `2026062316` | Disable AppsFlyer; Disable Sberbank advertising ID; Disable analytics libraries; Disable analytics manifest components | `ru.sberbankmobile.patched-base.apk` | **Неполный комплект:** patched base only | `c928f2f8c7424a11fcb42538e64fc0d6b0589caa211ea3c304e02371daa620ed` |
| Альфа-Банк | `ru.alfabank.mobile.android` | `12.60.07` / `2042600700` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.alfabank.mobile.android.apk` | Один APK; запуск не проверен | `4e4dc57095c59290c5904b673535f91eb6201ca5640d6f0b275ad62acbda2313` |
| ВТБ Онлайн | `ru.vtb24.mobilebanking.android` | `20.18.1.3` / `2090141585` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.vtb24.mobilebanking.android.apk` | Один APK; запуск не проверен | `5fcdb3295e2243c7a7f4a456fc64ab272adff5b482925319eb7216e56a8607ef` |
| 2ГИС | `ru.dublgis.dgismobile` | `7.29.1.632.4` / `282010632` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.dublgis.dgismobile.apk` | Один APK; запуск не проверен | `c69d4235d52f4730652e6e1c8b35c7a6e58f6d335295819d9e94ea8c7c3851c4` |
| Звук | `com.zvooq.openplay` | `4.117.0rs` / `511700129` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `com.zvooq.openplay.apk` | Один APK; запуск не проверен | `ec57f58f25df8400682efe6c203195ab6c83ff525cdd53424b13e2cd8ad56fde` |
| MAX | `ru.oneme.app` | `26.35.0` / `6861` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.oneme.app.patched-base.apk` | **Неполный комплект:** patched base only | `f7eb450f9ebca130b413a63afe62e3d53a3e7e6a16c8a8349c011cc3a76fecfb` |
| Госуслуги | `ru.rostel` | `27.1.0.9876-rustore` / `9876` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.rostel.patched-base.apk` | **Неполный комплект:** patched base only | `f9103cd5832ccf5374f9ae93c0a1b3ccee8a178cb37d8f647d8236e3cba937f6` |
| Ozon | `ru.ozon.app.android` | `19.38.0` / `2721` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.ozon.app.android.patched-base.apk` | **Неполный комплект:** patched base only | `b5dbd82943749bb10e82b555c928111ba6c7de8bce5d98007230af430b95a36e` |
| Wildberries | `com.wildberries.ru` | `7.8.3002-rustore` / `61085` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `com.wildberries.ru.apk` | Один APK; запуск не проверен | `c590816ff1db55f08ad8836f337d67e2f9d3a408ef90cfb34565db32d58a82d6` |
| Авито | `com.avito.android` | `234.5` / `3561` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `com.avito.android.apk` | Один APK; запуск не проверен | `413c81bb891fb6291fdfed3884da214d08da357c87a233eeec085f441e3967a5` |
| AliExpress Россия | `ru.aliexpress.buyer` | `8.89.1.3597464` / `844` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.aliexpress.buyer.patched-base.apk` | **Неполный комплект:** patched base only | `f41644f302a4b2aabdc22ce14899a09216905597d82f8fc46ecca1bd18b08118` |
| Перекрёсток | `ru.perekrestok.app` | `3.99.0` / `4128` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.perekrestok.app.apk` | Один APK; запуск не проверен | `f1f93fca2b7e4a8fca8321b2bd6bbc290679bd839135849c5ec209fdbdf0ed1b` |
| Whoosh | `com.punicapp.whoosh` | `4.0.0` / `418060` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `com.punicapp.whoosh.patched-base.apk` | **Неполный комплект:** patched base only | `8638006ef5c07df8286bc18fb353c6e6a4004bb78a4471ae5ca24a562cb8b41c` |
| Mir Pay | `ru.nspk.mirpay` | `1.64.5.350` / `405` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.nspk.mirpay.apk` | Один APK; запуск не проверен | `803a2457d1e112bdfff36409cf2bb84d2ad8175035ecf592cd8602beed1ea810` |
| Т-Банк | `com.idamob.tinkoff.android` | `8.4.2` / `13282` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components; Disable telemetry worker | `com.idamob.tinkoff.android.apk` | Один APK; запуск не проверен | `421e181075f5affb25e815b2e778f2ce008d1527947041a535627ace5cb3468f` |
| Яндекс Почта | `ru.yandex.mail` | `9.30.1` / `125935` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.yandex.mail.apk` | Один APK; запуск не проверен | `a60f7945135bafcbca257edd7d2ddb5ecc63ac6005090ab78330b32d9a417ca6` |
| билайн | `ru.beeline.services` | `5.48.5` / `4391` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.beeline.services.patched-base.apk` | **Неполный комплект:** patched base only | `0863cf81f50c4101ec4d6c05df9c8b24b4f889468162bdead4baa060b17ce41c` |
| Мой МТС | `ru.mts.mymts` | `6.77` / `150770030` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.mts.mymts.patched-base.apk` | **Неполный комплект:** patched base only | `a57cbf003c590907b1acdba41c48bbf037ef1c7bdb322ee82ae4cdcdf985af47` |
| МегаФон | `ru.megafon.mlk` | `4.69.0` / `42400548` | Disable AppsFlyer; Disable analytics libraries; Disable analytics manifest components | `ru.megafon.mlk.apk` | Один APK; запуск не проверен | `84ef2754a0f8524ae2b5f53afc79fa8cdd249ef05be45badad18fb84ecbad020` |

## Verification evidence

- RuStore source files and package/version/versionCode/SHA-256: `research/ru_apps_expansion.tsv` and `scripts/verify_rustore_downloads.py`.
- Current run: 24/24 successful in `manifest_draft.json`; each row records the source APK hashes, applied patch names and output hash.
- AppMetrica regression check on Yandex Maps output: `apkanalyzer dex code` shows `activate(Context, AppMetricaConfig)` sets `dataSendingEnabled=false`, calls the original SDK activation, then calls `setDataSendingEnabled(false)`. The setter forces its argument to false before its SDK call.
- A source DEX check found `io.appmetrica.analytics.AppMetrica.setDataSendingEnabled(Z)V` in all 16 targets containing the AppMetrica facade. The other eight targets contain no `io.appmetrica.analytics.AppMetrica` facade.
- Runtime launch, login, account, map-route, order, payment, notifications and deep-link flows are not verified for these rebuilt outputs. No financial/account flow was used.
- RuStore downloader project: https://github.com/Basil-AS/rustore-downloader; its documented API can return APK or split APK sources.
