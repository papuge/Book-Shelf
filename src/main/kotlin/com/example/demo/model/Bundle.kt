package com.example.demo.model

import javafx.beans.property.StringProperty
import tornadofx.*

class Bundle (
        override val title: String,
        override val author: String,
        override val genre: String,
        override val year: Int,
        override val publisher: String,
        override val envelopePath: String,
        var basketItems: MutableList<BasketItem>
): BasketItem {
    override var currencyPrice: StringProperty = "${calcPrice()} р.".toProperty()

    override fun calcPrice(): Double {
        var price = .0
        for (item in basketItems)
            price += item.calcPrice()
        return price
    }

    override fun toString(): String = this.basketItems.joinToString(", ")
}
