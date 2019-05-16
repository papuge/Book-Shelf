package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.OrderController
import com.example.demo.model.Orders


import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import tornadofx.*

class OrdersView : View("Account") {

    private val orderController: OrderController by inject()

    override val root = vbox(15){
        alignment = Pos.TOP_CENTER
        label("My orders") {
            addClass(Styles.tabName)
            style {
                backgroundColor += Color.KHAKI
            }
        }
        borderpane {
            center = listview(orderController.orders) {
                prefHeight = 600.0
                cellFormat {
                    graphicProperty().assignIfNull {
                        label("Empty")
                    }
                     graphic = vbox(8) {
                         label(it[Orders.items])
                         label(it[Orders.date]) {
                             style {
                                 fontStyle = FontPosture.ITALIC
                                 textFill = Color.SLATEBLUE
                                 fontSize = 15.px
                             }
                         }
                         label(it[Orders.total]) {
                             style {
                                 fontWeight = FontWeight.BOLD
                                 fontSize = 15.px
                             }
                         }
                     }
                }
            }
        }
    }
}
