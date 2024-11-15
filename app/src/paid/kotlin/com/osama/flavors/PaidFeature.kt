package com.osama.flavors

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PaidFeature {
    fun createRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
