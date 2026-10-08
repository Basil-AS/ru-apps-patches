// Ported from xob0t/morphe-patches (GPLv3), app/privacy/patches/analytics/DisableMyTrackerPatch.kt.
// Universal, app-agnostic. Verified present and unobfuscated in ru.oneme.app (MAX)
// 26.34.0 — see apps/ru.oneme.app/analysis/habr_audit_findings.md section C.1.
package app.privacy.patches.analytics

import app.morphe.patcher.patch.resourcePatch
import app.shared.*
import org.w3c.dom.Element

@Suppress("unused")
val disableMyTrackerPatch = resourcePatch(
    name = "Disable MyTracker",
    description = "Disables MyTracker manifest entry points.",
    default = false,
) {
    execute {
        document("AndroidManifest.xml").use { document ->
            val application = document.documentElement.childrenNamed("application").single() as Element

            val disabledComponents = application.disableComponentsWhere { name ->
                name.startsWith("com.my.tracker.") ||
                    name.startsWith("ru.mail.mytracker.") ||
                    name.contains(".mytracker.", ignoreCase = true)
            }

            println("Disable MyTracker: disabled $disabledComponents manifest components.")
        }
    }
}
