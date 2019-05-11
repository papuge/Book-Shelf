package com.example.demo.controller

import tornadofx.*

class UserController(): Controller() {
    var isAutherized: Boolean = false

    fun authenticate(username: String, password: String) {
        val hash = password.hashCode()
    }
}