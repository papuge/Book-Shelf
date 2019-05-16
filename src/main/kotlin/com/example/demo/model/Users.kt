package com.example.demo.model

import org.jetbrains.exposed.dao.IntIdTable

object Users : IntIdTable() {
    val username = varchar("username",25).uniqueIndex()
    val passwordHash = integer("passwordHash")
    var email = varchar("email", 25)
}