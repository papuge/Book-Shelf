package com.example.demo.model.CurrencyStrategy


object Currency {
    var currentCurrency: String = "BYN"
    var currencyStrategy: CurrencyStrategy = BynStrategy()

    fun getPrice(price: Double): String {
        return when (currentCurrency) {
            "USD"-> {
                currencyStrategy = UsdStrategy()
                currencyStrategy.getPriceInCurrency(price)
            }
            "EUR" -> {
                currencyStrategy = EurStrategy()
                currencyStrategy.getPriceInCurrency(price)
            }
            else -> {
                currencyStrategy = BynStrategy()
                currencyStrategy.getPriceInCurrency(price)
            }
        }
    }
}