package com.osama.flavors

import com.osama.flavors.di.FlavorAction

class PaidAction : FlavorAction {
    override fun performAction(): String {
        val paidFeature = PaidFeature()
        // Simulate using the paid feature with Retrofit
        return paidFeature.makeDummyApiCall()
    }
}
