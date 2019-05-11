package com.example.demo.model

import tornadofx.*
import javax.json.JsonObject

data class Book (
    override val title: String,
    override var genre: String,
    override val author: String,
    var price: Double,
    override val year: Int = 0,
    override val publisher: String = "",
    override var envelopePath: String = ""
): BasketItem {
    override fun calcPrice(): Double = this.price
    override fun toString(): String = this.title
}
