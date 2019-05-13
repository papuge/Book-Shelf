package com.example.demo.model

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection


fun <T> connectAndExec(statement: Transaction.() -> T) : T {
    val db = Database.connect("jdbc:mysql://localhost:3306/test", driver = "com.mysql.cj.jdbc.Driver",
            user = "root", password = "fks1")
    return transaction(Connection.TRANSACTION_SERIALIZABLE, 3, db, statement)
}