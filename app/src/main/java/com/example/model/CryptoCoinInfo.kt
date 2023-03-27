package com.example.model


import com.google.gson.annotations.SerializedName

data class CryptoCoinInfo(
    @SerializedName("description")
    val description: Description,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("market_data")
    val marketData: MarketData
)