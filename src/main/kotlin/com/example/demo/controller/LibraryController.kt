package com.example.demo.controller

import com.example.demo.model.*
import com.example.demo.view.LibraryView
import javafx.collections.FXCollections
import tornadofx.*

class LibraryController: Controller() {

    val items = FXCollections.observableArrayList<BasketItem>(
            Book("Flowers for Algernon", "Fiction", "Daniel Keyes",
                    14.84, 2016, "Ecsmo", "/fa.jpg"),
            Book("Harry Potter", "Fiction", "J. K. Rowling",
                    125.25, 2007, "Arthur A. Levine Books",
                    "/hp.jpg"),
            Book("Lord of the Rings", "Fiction", "J.R.R. Tolkien",
                    37.0, 2012, "Del Rey", "/lor.jpg"),
            Book("Umbrella Academy", "Comic", "Gerard Way",
                    27.0, 2008, "Dark Horse Books", "/ac.jpg")
    )

    val data = SortedFilteredList<BasketItem>(items)

    fun itemDisplayScope(item: BasketItem?): Scope {
        val scope = ItemScope()
        scope.model.item = item
        return scope
    }

    class ItemScope: Scope() {
        val model = BasketItemModel()
    }
}