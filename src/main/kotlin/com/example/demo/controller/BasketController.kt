package com.example.demo.controller

import com.example.demo.model.BasketItem
import com.example.demo.model.CurrencyStrategy.Currency
import javafx.beans.property.*
import javafx.collections.FXCollections
import tornadofx.*

class BasketController: Controller() {
    private val orderController: OrderController by inject()

    class ItemInBasket(basketItem: BasketItem) {
        val name = SimpleStringProperty(basketItem.title)
        var amount = 1.toProperty()
        private val onePrice = basketItem.calcPrice()
        val price = Currency.getPrice(calcPrice()).toProperty()

        fun calcPrice() = onePrice * amount.value
        fun priceToString() = Currency.getPrice(calcPrice())
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
        item.price.value = item.priceToString()
    }

    fun dec(item: ItemInBasket) {
        if (item.amount.value > 1) {
            item.amount.value -= 1
            item.price.value = item.priceToString()
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

    fun getTotalPrice(): String {
        var price = .0
        for (i in itemsInBasket) {
            price += i.calcPrice()
        }
        return Currency.getPrice(price)
    }

    fun confirmOrder() {
        orderController.addOrder(itemsInBasket, getTotalPrice())
        orderController.updateOrders()
        itemsInBasket.clear()
    }
}