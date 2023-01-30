package com.example.model

data class CryptoCoin(
    val nameCoin: String,
    val acronymCoin: String,
    val priceCoin: Double,
    var favoriteSelected: Boolean = false
)


var coins: MutableList<CryptoCoin> = mutableListOf(

    CryptoCoin("BitCoin", "BTC", 12000.00),

    CryptoCoin("Ethereum", "ETH", 20100.00),

    CryptoCoin("Theter", "USDT", 8000.00),

    CryptoCoin("BinanceCoin", "BNB", 1000.00),

    CryptoCoin("Sweet", "BTC", 1500.00),

    CryptoCoin("Ober", "ETH", 50000.00),

    CryptoCoin("Tokenyear", "USDT", 60000.00),

    CryptoCoin("Binance2", "BN2", 19000.00),

    CryptoCoin("Binance3", "BN3", 1000.00),

    CryptoCoin("Binance6", "BN6", 1000.00),

    CryptoCoin("Binance9", "BN9", 71000.00),

    CryptoCoin("Binance1", "BN1", 7000.00),

    CryptoCoin("Binance1", "BN1", 75454.00),

    CryptoCoin("Binance1", "BN1", 85500.00),

    )


