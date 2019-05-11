package com.example.demo.model

import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object Users : IntIdTable() {
    val userName = varchar("userName",25).uniqueIndex()
    val passwordHash = integer("passwordHash")
    val firstName = varchar("firstName",50)
    val secondName = varchar("secondName", 50)
    var email = varchar("email", 25)
    var phone = varchar("phone", 12)
}