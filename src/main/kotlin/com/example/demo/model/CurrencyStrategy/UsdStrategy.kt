package com.example.demo.model.CurrencyStrategy

class UsdStrategy: CurrencyStrategy {
    override fun getPriceInCurrency(price: Double): String =
            String.format("%.2f  $", price / 2.092)
}