package com.osama.flavors

import com.google.firebase.analytics.FirebaseAnalytics

class FreeAction : FlavorAction {
    override fun performAction(): String {
        return "Performing action for Free version"
    }

    fun logEvent(analytics: FirebaseAnalytics, eventName: String) {
        analytics.logEvent(eventName, null)
    }
}

object FlavorFactory {
    fun getFlavorAction(): FlavorAction {
        return FreeAction()
    }
}
