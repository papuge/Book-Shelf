package com.example.demo.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Order(
    var items: List<Pair<Book, Int>>,
    var comment: String,
    var deliveryDate: String = "",
    var itemsPrice: Double =  .0
) { }