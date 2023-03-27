package com.example.Presentation.details


fun convertCurrentPriceToUiModel(currentCoinType: CurrentCoinType, value: Double): String =
    when (currentCoinType) {
        CurrentCoinType.USD -> {
            "$value USD"
        }
        CurrentCoinType.EUR -> {
            "$value EUR"
        }
        CurrentCoinType.BTC -> {
            "$value BTC"
        }
        CurrentCoinType.BRL -> {
            "$value BRL"
        }
        CurrentCoinType.ETH -> {
            "$value ETH"
        }
        CurrentCoinType.JPY -> {
            "$value JPY"
        }
    }

enum class CurrentCoinType {
    USD,
    EUR,
    BRL,
    BTC,
    ETH,
    JPY
}