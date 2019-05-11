package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.BasketController
import javafx.collections.FXCollections
import javafx.geometry.Pos
import javafx.scene.Parent
import javafx.scene.paint.Color
import tornadofx.*

class BasketView : View("Basket") {

    val bController : BasketController by inject()

    override val root = vbox {
        alignment = Pos.TOP_CENTER
        label("Basket") {
            addClass(Styles.tabName)
            style {
                backgroundColor += Color.LAVENDER
            }
        }

        listview(bController.itemsInBasket) {
            cellFormat {
                graphic = borderpane() {
                    addClass(Styles.basketItems)
                    left = label(it.name.value)
                    right = hbox(2.0) {
                        label().bind(it.price)
                        button("+") {
                            action {
                                bController.inc(it)
                            }
                        }
                        label().bind(it.amount)
                        button("-") {
                            action {
                                bController.dec(it)
                            }
                        }
                        button("Remove") {
                            style(append = true) {
                                textFill = Color.WHITE
                                backgroundColor += c("#f43349")
                                prefWidth = 85.px
                            }
                            action {
                                bController.remove(item)
                            }
                        }
                    }
                }
            }
        }

        button("Make order") {
            alignment = Pos.CENTER
            style {
                backgroundColor += Color.DODGERBLUE
                textFill = Color.WHITE
                fontSize = 15.px
            }
            action {
                if(bController.canMakeOrder()) {
                    find<TotalBasket>().openModal()
                }
                else {
                    find<EmptyBasketView>().openModal()
                }
            }
        }
    }
}

class EmptyBasketView: Fragment() {
    override val root = label("Basket is empty!") {
        alignment = Pos.CENTER
        style {
            textFill = Color.RED
            fontSize = 18.px
        }
    }
}

class TotalBasket: Fragment() {
    val bController : BasketController by inject()
    override val root = vbox(20.0){
        alignment = Pos.CENTER
        addClass(Styles.loginScreen)
        label("Total: " + bController.getTotalPrice().toString())
        button("Confirm") {
            style {
                backgroundColor += Color.DODGERBLUE
                textFill = Color.WHITE
                fontSize = 15.px
                spacing = 20.px
            }
            action {

            }
        }
    }

    override fun onDock() {
        with(root) {
            resize(500.0, 500.0)
        }
    }
}