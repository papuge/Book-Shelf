package com.example.demo.controller

import com.example.demo.model.UserModel
import com.example.demo.model.Users
import com.example.demo.model.connectAndExec
import com.example.demo.view.LoginView
import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.insertAndGetId
import org.jetbrains.exposed.sql.select
import tornadofx.*

class UserController: Controller() {
    private val loginScreen: LoginView by inject()
    private val bController: BasketController by inject()
    private val orderController: OrderController by inject()

    var isAuthorized: Boolean = false
    var userId: EntityID<Int> = EntityID(0, Users)

    fun authenticate(username: String, password: String): Boolean {
        val hash = password.hashCode()
        val users = connectAndExec {
            Users.select { (Users.username like username) and (Users.passwordHash eq hash) }.map { it }
        }
        if (users.isNotEmpty()) {
            val user = users.first()
            isAuthorized = true
            userId = user[Users.id]
            with(config) {
                set(USERNAME to username)
                set(PASSWORD to password)
                save()
            }
            loginScreen.clean()
            orderController.changeUserOrders()
            return true
        }
        return false
    }

    fun autoLogin(): Boolean {
        with(config) {
            if (containsKey(USERNAME) && containsKey(PASSWORD)) {
                return authenticate(string(USERNAME), string(PASSWORD))
            }
        }
        return false
    }

    fun logout() {
        bController.itemsInBasket.clear()
        with(config) {
            remove(USERNAME)
            remove(PASSWORD)
            save()
        }
    }

    fun register(model: UserModel): Boolean {
        var isAlready = false
        connectAndExec {
            isAlready = Users.select {
                (Users.username like model.username.value) and (Users.passwordHash eq model.
                        password.value.hashCode())
            }.count() > 0
            if(!isAlready)
                Users.insertAndGetId {
                    it[username] = model.username.value
                    it[passwordHash] = model.password.value.hashCode()
                    it[email] = model.email.value
                }
        }
        if (!isAlready)
            return true

        return false
    }

    companion object {
        val USERNAME = "username"
        val PASSWORD = "password"
    }
}