package com.example.demo.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Order(
    var items: List<Pair<BasketItem, Int>>,
    var date: String,
    var itemsPrice: Double =  .0
) { }