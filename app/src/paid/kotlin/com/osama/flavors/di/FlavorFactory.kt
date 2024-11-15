package com.osama.flavors.di

import com.osama.flavors.PaidAction

object FlavorFactory {
    fun getFlavorAction(): FlavorAction = PaidAction()
}