package com.osama.flavors

import com.google.firebase.analytics.FirebaseAnalytics
import com.osama.flavors.di.FlavorAction

class FreeAction : FlavorAction {
    override fun performAction(): String {
        val freeFeature = FreeFeature()
        // Perform action specific to the Free version
        return "Performing action for Free version"
    }

    fun logEvent(analytics: FirebaseAnalytics, eventName: String) {
        analytics.logEvent(eventName, null)
    }
}

