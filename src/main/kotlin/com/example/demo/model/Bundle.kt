package com.example.demo.model

class Bundle (
        var basketItems: MutableList<BasketItem>
): BasketItem {
    override fun calcPrice(): Double {
        var price = .0
        for (item in basketItems)
            price += item.calcPrice()
        return price
    }
}