package com.example.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class CryptoRetrofit {

    companion object {
        fun getCryptoRetrofit(): Retrofit {
            return Retrofit.Builder().baseUrl(API_VERSION_HEADER)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }

        const val API_VERSION_HEADER = "https://api.coingecko.com/api/v3/"
    }

}