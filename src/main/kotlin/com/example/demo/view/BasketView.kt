package com.example.demo.view

import com.example.demo.app.Styles
import javafx.scene.paint.Color
import tornadofx.*

class BasketView : View("BasketItem") {
    val orders = listOf("One", "Two", "Three").observable()
    override val root = vbox {
        label("BasketItem") {
            addClass(Styles.tabName)
            style {
                backgroundColor += Color.LAVENDER
            }
        }
        val greekLetters = listOf("Alpha","Beta",
                "Gamma","Delta","Epsilon").observable()

        listview(greekLetters) {
            cellFormat {
                graphic = vbox(10.0) {
                    label(it)
                    button("Add") {
                        style {
                            textFill = Color.WHITE
                            backgroundColor += c("#28e090")
                        }
                    }
                }
            }
        }
    }
}
