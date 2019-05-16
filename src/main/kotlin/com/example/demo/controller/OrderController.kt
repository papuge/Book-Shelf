package com.example.demo.controller

import com.example.demo.model.Orders
import com.example.demo.model.connectAndExec
import javafx.collections.ObservableList
import org.jetbrains.exposed.sql.*
import tornadofx.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class OrderController: Controller() {

    private val userController: UserController by inject()
    private var lastCount: Int = 0

    var orders = connectAndExec {
        Orders.select { Orders.userId eq userController.userId.value }.
                toMutableList().observable()
    }

    fun addOrder(itemsInBasket: ObservableList<BasketController.ItemInBasket>, totalPrice: String) {
        val dateNow = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        connectAndExec {
            Orders.insert {
                it[items] = itemsInBasket.joinToString(",\n") {
                    "${it.name.value} x ${it.amount.value}"
                }
                it[userId] = userController.userId.value
                it[date] = dateNow.format(formatter)
                it[total] = totalPrice
            }
        }
    }

    fun updateOrders() {
        if (isNewOrder()) {
            val lastOrder = connectAndExec {
                Orders.select { Orders.userId eq userController.userId.value }.last()
            }
            orders.add(0, lastOrder)
        }
    }

    fun changeUserOrders() {
        orders.clear()
        orders.addAll(connectAndExec {
            Orders.select { Orders.userId eq userController.userId.value }.
                    orderBy(Orders.id to SortOrder.DESC).
                    toList()
        })

        isNewOrder()  // to init lastCount
    }

    private fun isNewOrder(): Boolean {
        val ordersCount = connectAndExec {
            Orders.select { Orders.userId eq userController.userId.value }.count()
        }
        return when {
            ordersCount > 0 -> {
                val lastOrder = connectAndExec {
                    Orders.select { Orders.userId eq userController.userId.value}.last()
                }
                if (lastOrder[Orders.id].value > lastCount) {
                    lastCount = lastOrder[Orders.id].value
                    return true
                }
                false
            }
            else -> false
        }
    }

}