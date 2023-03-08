package com.example.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CryptoInfoRetrofit {
    companion object {
        fun getCryptoInfoRetrofit(baseUrl: String): Retrofit {
            return Retrofit.Builder().
            baseUrl("https://coingecko.com/api/v3/").
            addConverterFactory(GsonConverterFactory.create()).
            build()
        }
    }
}