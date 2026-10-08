// Ported from Jl4cTuk/morphe-patches (GPLv3), app/template/patches/ozon/notifications/Fingerprints.kt.
package app.ru_apps.ozon_jl4ctuk.notifications

import app.morphe.patcher.Fingerprint

/** Matches the shared Ozon Push SDK handler used by FCM, RuStore Push, and HMS. */
object OzonPushServiceDelegateFingerprint : Fingerprint(
    returnType = "V",
    parameters = listOf(
        "Lru/ozon/push/sdk/external/service/RemoteMessage;",
        "L",
        "Ljava/lang/String;",
    ),
    strings = listOf(
        "OzonPushServiceDelegate",
        "The received push message isn't an Ozon push message.",
        "pw_msg_tag",
    ),
)
