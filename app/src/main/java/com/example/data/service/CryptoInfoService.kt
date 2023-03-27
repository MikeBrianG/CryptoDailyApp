package com.example.data.service

import com.example.data.NetWorkEndPoints
import com.example.model.CryptoCoinInfo
import com.example.model.Description
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface CryptoInfoService {
    @GET(NetWorkEndPoints.GET_CRYPTO_COIN_DETAIL)
    suspend fun getCryptoCoinInfo(
        @Path ("id") id: String
    ): Response<CryptoCoinInfo>
}