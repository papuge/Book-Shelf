package com.example.demo.controller

import com.example.demo.model.BasketItem
import javafx.collections.FXCollections
import tornadofx.*

class BasketController: Controller() {
    val itemsInBasket =
            FXCollections.observableArrayList<Pair<BasketItem, Int>>()

    fun add(item: BasketItem) {
        val (items, amount) = itemsInBasket.unzip()
        if (items.contains(item)) {
            itemsInBasket[items.indexOf(item)].second!!.plus(1)
        }
        else {
            itemsInBasket.add(Pair(item, 1))
        }
    }
}