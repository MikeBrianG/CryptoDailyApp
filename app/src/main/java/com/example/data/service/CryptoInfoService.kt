package com.example.data.service

import com.example.model.CryptoCoin
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface CryptoInfoService {
    @GET("")
    suspend fun getCryptoCoinInfo(
        @Path(value = "id", encoded = true) id: String
    ): Response<CryptoCoin>
}