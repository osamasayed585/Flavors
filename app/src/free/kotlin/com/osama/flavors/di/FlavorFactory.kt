package com.osama.flavors.di

import com.osama.flavors.FreeAction

object FlavorFactory {
    fun getFlavorAction(): FlavorAction = FreeAction()
}