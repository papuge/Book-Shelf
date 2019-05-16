package com.example.demo.app


import com.example.demo.view.LoginView
import tornadofx.App

class MyApp: App(LoginView::class, Styles::class) {
    init {

//        Database.connect("jdbc:mysql://localhost:3306/test", driver = "com.mysql.cj.jdbc.Driver",
//                user = "root", password = "fks1")
//        transaction {
//            addLogger(StdOutSqlLogger)
//            SchemaUtils.create(Orders)
//            val id = Users.insertAndGetId {
//                it[username] = "coose"
//                it[passwordHash] = "1234".hashCode()
//                it[email] = "coose@gmail.com"
//            }
//            Users.select { (Users.username like "coose") }.first()
//        }
    }
}