package com.example.demo.controller

import com.example.demo.model.*
import com.example.demo.model.CurrencyStrategy.Currency
import javafx.collections.FXCollections
import tornadofx.*

class LibraryController: Controller() {

    private val bController: BasketController by inject()

    var items = FXCollections.observableArrayList<BasketItem>(
            Book("Flowers for Algernon", "Daniel Keyes","Fiction",
                    14.84, 2016, "Ecsmo", "/fa.jpg"),
            Bundle("Harry Potter", "J. K. Rowling","Fiction",
                    2007, "Arthur A. Levine Books",
                    "/hp.jpg", arrayListOf(
                    Book("The Philosopher's Stone", "J. K. Rowling","Fiction",
                            50.50, 2007, "Arthur A. Levine Books"),
                    Book("The Chamber of Secrets", "J. K. Rowling", "Fiction",
                            75.25, 2007, "Arthur A. Levine Books")
            )),
            Bundle("Lord of the Rings", "J.R.R. Tolkien", "Fiction",2012,
                    "Del Rey", "/lor.jpg", arrayListOf(
                    Book("The Fellowship of the Ring", "J.R.R. Tolkien", "Fiction",
                            19.0, 2012, "Del Rey"),
                    Book("The Two Towers", "J.R.R. Tolkien", "Fiction",
                            16.0, 2012, "Del Rey"),
                    Book("The Return of the King", "J.R.R. Tolkien", "Fiction",
                            17.0, 2012, "Del Rey")
            )),
            Book("Umbrella Academy", "Gerard Way", "Comic",
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

    fun addToBasket(item: BasketItem) {
        bController.add(item)
    }

    fun setCurrency(currency: String) {
        Currency.currentCurrency = currency
        for (i in items) {
            i.currencyPrice.value = Currency.getPrice(i.calcPrice())
        }

        for (i in bController.itemsInBasket) {
            i.price.value = i.priceToString()
        }
    }
}