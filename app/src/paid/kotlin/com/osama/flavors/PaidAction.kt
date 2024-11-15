package com.osama.flavors

import com.osama.flavors.di.FlavorAction

class PaidAction : FlavorAction {
    override fun performAction(): String {
        val paidFeature = PaidFeature()
        val retrofit = paidFeature.createRetrofitInstance()
        // Use the Retrofit instance to make API calls
        return "Performing action for Paid version"
    }
}
