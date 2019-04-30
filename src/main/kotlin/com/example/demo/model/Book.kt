package com.example.demo.model

data class Book (
    val title: String,
    var genre: Genres,
    val author: String,
    var price: Double,
    val language: String = "",
    val year: Int = 0,
    val publisher: String = "",
    var envelopePath: String = ""
): BasketItem {
    override fun calcPrice(): Double = this.price
    override fun toString(): String = this.title
}