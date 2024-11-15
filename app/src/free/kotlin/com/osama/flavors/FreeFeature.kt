package com.osama.flavors

import com.google.firebase.analytics.FirebaseAnalytics

class FreeFeature {
    fun logEvent(analytics: FirebaseAnalytics, eventName: String) {
        analytics.logEvent(eventName, null)
    }
}