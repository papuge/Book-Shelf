package com.example.demo.controller

import com.example.demo.model.BasketItem
import com.example.demo.view.BasketView
import javafx.beans.property.*
import javafx.collections.FXCollections
import tornadofx.*

class BasketController: Controller() {
    val view: BasketView by inject()

    class ItemInBasket(basketItem: BasketItem) {
        val name = SimpleStringProperty(basketItem.title)
        var amount = 1.toProperty()
        val one_price = basketItem.calcPrice()
        var price = one_price.toProperty()

        fun calcPrice() = one_price * amount.value
    }

    val itemsInBasket =
            FXCollections.observableArrayList<ItemInBasket>()

    fun add(item: BasketItem) {  // following operation is from library
        for (i in itemsInBasket) {
            if (i.name.value == item.title) {  // contains item
                return
            }
        }
        itemsInBasket.add(ItemInBasket(item))
    }

    fun inc(item: ItemInBasket) {
        item.amount.value += 1
        item.price.value = item.calcPrice()
    }

    fun dec(item: ItemInBasket) {
        if (item.amount.value > 1) {
            item.amount.value -= 1
            item.price.value = item.calcPrice()
        }
    }

    fun remove(item: ItemInBasket) {
        itemsInBasket.remove(item)
    }

    fun canMakeOrder(): Boolean {
        if(itemsInBasket.isEmpty()) {
            return false
        }
        return true
    }

    fun getTotalPrice(): Double {
        var price = .0
        for (i in itemsInBasket) {
            price += i.calcPrice()
        }
        return price
    }
}