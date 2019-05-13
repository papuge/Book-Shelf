package com.example.demo.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object Users : IntIdTable() {
    val username = varchar("username",25).uniqueIndex()
    val passwordHash = integer("passwordHash")
    var email = varchar("email", 25)
}