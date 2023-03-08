package com.example.model


import com.google.gson.annotations.SerializedName

data class CryptoCoin(
    @SerializedName("current_price")
    val currentPrice: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("market_cap")
    val marketCap: Long,
    @SerializedName("market_cap_rank")
    val marketCapRank: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String,

    var favorite: Boolean = false
)