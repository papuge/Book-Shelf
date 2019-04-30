package com.example.demo.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class User(
    var id: String,
    var firstName: String,
    var secondName: String,
    var email: String,
    var phoneNumber: String
) {
    override fun toString(): String = "$firstName $secondName"
}