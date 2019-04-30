package com.example.demo.view

import javafx.geometry.Pos
import javafx.scene.control.TabPane
import javafx.scene.paint.Color
import tornadofx.*

class TabbedMenuView : View("Book Store") {
    override val root = tabpane {
            style {
                fontSize = 15.px
            }
            tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE

            tab(LibraryView::class)
            tab(BasketView::class)
            tab(OredersView::class)

    }

}
