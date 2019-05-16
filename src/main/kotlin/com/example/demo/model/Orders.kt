package com.example.demo.model

import org.jetbrains.exposed.dao.IntIdTable


object Orders : IntIdTable() {
    val items = varchar("items",1500)
    val userId = integer("userId")
    var date = varchar("date", 15)
    var total = varchar("total", 20)
}