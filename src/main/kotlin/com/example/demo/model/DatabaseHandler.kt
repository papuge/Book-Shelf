package com.example.demo.model

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class DatabaseHandler {
    val db = Database.connect("jdbc:mysql://localhost:3306/test", driver = "com.mysql.jdbc.Driver",
            user = "root", password = "your_pwd")
}