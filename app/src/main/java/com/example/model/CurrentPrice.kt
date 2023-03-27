package com.example.model


import com.google.gson.annotations.SerializedName

data class CurrentPrice(
    @SerializedName("eur")
    val eur: Double,
    @SerializedName("usd")
    val usd: Double,
    @SerializedName("btc")
    val btc: Double,
    @SerializedName("brl")
    val brl: Double,
    @SerializedName("eth")
    val eth: Double,
    @SerializedName("jpy")
    val jpy: Double,
    )