package com.example.demo.view

import com.example.demo.app.Styles
import javafx.geometry.Pos
import javafx.scene.paint.Color
import tornadofx.*


class LibraryView : View("Library") {
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
            style{
                spacing = 10.px
                maxWidth = 350.px
            }
            isFocusTraversable = false
        }
        borderpane {
            val books = listOf("1984", "Do androids\ndream of\nelectric sheep?", "Dandelion Wine")
            center = datagrid(books) {
                cellCache {
                    borderpane{
                        center = label(it)
                        bottom = button("Add") {
                            useMaxWidth = true
                            style {
                                textFill = Color.WHITE
                                backgroundColor += c("#28e090")
                                maxWidth = 50.px
                                spacing = 10.px
                            }
                            action {
                                find<BookView>().openWindow()
                            }
                        }
                    }
                }
            }
        }
    }
}

class BookView: Fragment() {
    override val root = vbox(15) {
        label("bugaga")
    }
}
