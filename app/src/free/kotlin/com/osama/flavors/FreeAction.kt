package com.osama.flavors

import com.osama.flavors.di.FlavorAction

class FreeAction : FlavorAction {
    override fun performAction(): String {
        val freeFeature = FreeFeature()
        // Demonstrate free feature logic
        return freeFeature.logFreeFeatureUsage()
    }
}

