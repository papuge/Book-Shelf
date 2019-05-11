package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.LibraryController
import com.example.demo.model.Book
import javafx.geometry.Point2D
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.util.Duration
import tornadofx.*
import java.awt.Font


class LibraryView : View("Library") {

    val libController: LibraryController by inject()

    override val root = vbox(15){
        alignment = Pos.TOP_CENTER
        label("Library") {
            addClass(Styles.tabName)
            style {
                backgroundColor += Color.LIGHTBLUE
            }
        }
        textfield {
            promptText = "Search"
            libController.data.filterWhen(textProperty(),
                    { query, item -> item.title.contains(query, ignoreCase = true)
                            || item.author.contains(query, ignoreCase = true)})
            style{
                spacing = 10.px
                maxWidth = 350.px
            }
            isFocusTraversable = false
        }
        borderpane {
            center = datagrid(libController.data) {
                cellHeight = 225.0
                onUserSelect(2) {
                    val displayScope = libController.itemDisplayScope(selectedItem)
                    find(ItemView::class, scope = displayScope).openWindow()
                }
                cellCache {
                    vbox(9.0) {
                        alignment = Pos.TOP_CENTER
                        label(it.title)
                        imageview(it.envelopePath) {
                            fitHeight = 120.0
                            fitWidth = 100.0
                            spacing = 10.0
                        }
                        label(it.calcPrice().toString())
                        button("Add") {
                            alignment = Pos.BOTTOM_CENTER
                            style {
                                textFill = Color.WHITE
                                backgroundColor += c("#28e090")
                            }
                            action {
                                libController.addToBasket(it)
                                scale(Duration(350.0), Point2D(2.0, 2.0),
                                        reversed = true)
                            }
                        }
                    }
                }
            }
        }
    }
}

class ItemView(): Fragment() {
    override val scope = super.scope as LibraryController.ItemScope
    private val model = scope.model

    override val root = scrollpane {
        style {
            backgroundColor += Color.WHITE
        }
        vbox(25.0) {
            alignment = Pos.CENTER
            addClass(Styles.loginScreen)
            label(model.title)
            label("By " + model.author.value) {
                style {
                    fontStyle = FontPosture.ITALIC
                }
            }
            label(model.genre.value)
            imageview(model.envelopePath) {
                fitHeight = 350.0
                fitWidth = 300.0
                spacing = 10.0
            }
            label("Publisher: " + model.publisher.value + ", "
                    + model.year.value)
            label(model.price.value.toString())
        }
    }
}
