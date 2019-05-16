package com.example.demo.model

import javafx.beans.property.StringProperty
import tornadofx.*

class Book (
    override val title: String,
    override val author: String,
    override var genre: String,
    var price: Double,
    override val year: Int = 0,
    override val publisher: String = "",
    override var envelopePath: String = "",
    override var currencyPrice: StringProperty = ("$price р.").toProperty()
): BasketItem {
    override fun calcPrice(): Double = this.price
    override fun toString(): String = this.title
}
