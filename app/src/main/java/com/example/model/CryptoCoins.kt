package com.example.model

data class CryptoCoin(
    val nameCoin: String,
    val acronymCoin: String,
    val priceCoin: Double,
    var favoriteSelected: Boolean = false
)


var coins: MutableList<CryptoCoin> = mutableListOf(

    CryptoCoin("BitCoin", "BTC", 12.000),

    CryptoCoin("Ethereum", "ETH", 20.100),

    CryptoCoin("Theter", "USDT", 8.000),

    CryptoCoin("BinanceCoin", "BNB", 1.000),

    CryptoCoin("Sweet", "BTC", 15.700),

    CryptoCoin("Ober", "ETH", 50.000),

    CryptoCoin("Tokenyear", "USDT", 60.000),

    CryptoCoin("Binance2", "BN2", 19.000),

    CryptoCoin("Binance3", "BN3", 1.000),

    CryptoCoin("Binance6", "BN6", 1.000),

    CryptoCoin("Binance9", "BN9", 71.000),

    CryptoCoin("Binance1", "BN1", 7.000),

    CryptoCoin("Binance1", "BN1", 75454.000),

    CryptoCoin("Binance1", "BN1", 855000.0),

    )


