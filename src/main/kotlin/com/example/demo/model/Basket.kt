package com.example.demo.model

class Basket(
        var user: User,
        var items: MutableMap<BasketItem, Int>
) {
    fun add(item: BasketItem) {
        if (items.containsKey(item)) {
            items[item]?.plus(1)
        }
        else
            items[item] = 1
    }

    fun remove(item: BasketItem, all: Boolean = false) {
        if (!all && items[item]!! > 1) {
            items[item]?.minus(1)
        }
        else {
            items.remove(item)
        }
    }
}