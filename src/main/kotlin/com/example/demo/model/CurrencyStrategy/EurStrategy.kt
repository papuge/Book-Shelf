package com.example.demo.model.CurrencyStrategy

class EurStrategy: CurrencyStrategy {
    override fun getPriceInCurrency(price: Double): String =
            String.format("%.2f  €", price / 2.345)
}