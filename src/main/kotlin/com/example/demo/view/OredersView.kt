package com.example.demo.view

import com.example.demo.app.Styles


import javafx.geometry.Pos
import javafx.scene.paint.Color
import tornadofx.*

class OredersView : View("Orders") {
    override val root = vbox(15){
        alignment = Pos.TOP_CENTER
        label("My orders") {
            addClass(Styles.tabName)
            style {
                backgroundColor += Color.KHAKI
            }
        }
        borderpane {
            val books = listOf("1984", "Blade runner", "Dandelion Wine")
            center = datagrid(books) {
                cellCache {
                    label(it)
                }
            }
        }
    }
}
