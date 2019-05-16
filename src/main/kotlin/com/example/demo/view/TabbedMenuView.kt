package com.example.demo.view

import com.example.demo.controller.UserController
import javafx.geometry.Pos
import javafx.scene.control.TabPane
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class TabbedMenuView : View("Book Store") {
    private val controller: UserController by inject()

    override val root = tabpane {
        style {
            fontSize = 15.px
        }
        tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE

        tab(LibraryView::class)
        tab(BasketView::class)
        tab(OrdersView::class)
        tab("Logout") {
            button("Logout") {
                alignment = Pos.CENTER
                action {
                    controller.logout()
                    replaceWith<LoginView>(sizeToScene = true)
                }
                style {
                    maxWidth = infinity
                    fillWidth = true
                    fontWeight = FontWeight.BOLD
                    fontFamily = "Noto Sans Medium"
                    fontSize = 32.px
                    backgroundColor += Color.LIGHTPINK
                    prefHeight = 65.px
                }
            }
        }

    }

}
