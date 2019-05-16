package com.example.demo.model.CurrencyStrategy

interface CurrencyStrategy {
    // Price in string format
    fun getPriceInCurrency(price: Double): String
}