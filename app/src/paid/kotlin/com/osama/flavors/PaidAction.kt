package com.osama.flavors

class PaidAction : FlavorAction {
    override fun performAction(): String {
        return "Performing action for Paid version"
    }

    fun logEvent(analytics: FirebaseAnalytics, eventName: String) {
        analytics.logEvent(eventName, null)
    }
}

object FlavorFactory {
    fun getFlavorAction(): FlavorAction {
        return PaidAction()
    }
}
