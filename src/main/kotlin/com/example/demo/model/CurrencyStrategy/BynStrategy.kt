package com.example.demo.model.CurrencyStrategy

class BynStrategy: CurrencyStrategy {
    override fun getPriceInCurrency(price: Double): String =
            String.format("%.2f  р.", price)
}