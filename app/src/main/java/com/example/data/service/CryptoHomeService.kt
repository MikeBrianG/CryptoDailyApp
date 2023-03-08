package com.example.data.service

import com.example.data.NetWorkEndPoints
import com.example.model.CryptoCoin
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface CryptoHomeService {


    @GET(NetWorkEndPoints.GET_CRYPTO_COINS_LIST)
   suspend fun getCryptoCoin(
    ): Response<List<CryptoCoin>>
}
