package com.example.demo.model

import tornadofx.*
import javax.json.JsonObject

class Bundle (
        override val title: String,
        override val author: String,
        override val genre: String,
        override val envelopePath: String,
        override val publisher: String,
        override val year: Int,
        var basketItems: MutableList<BasketItem>
): BasketItem {
    override fun calcPrice(): Double {
        var price = .0
        for (item in basketItems)
            price += item.calcPrice()
        return price
    }

    override fun toString(): String = this.basketItems.joinToString(", ")
}
