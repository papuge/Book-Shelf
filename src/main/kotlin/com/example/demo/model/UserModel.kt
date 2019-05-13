package com.example.demo.model

import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class UserModel: ViewModel() {
    var username = bind { SimpleStringProperty() }
    var password = bind { SimpleStringProperty() }
    var email = bind { SimpleStringProperty() }
}