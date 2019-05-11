package com.example.demo.view

import com.example.demo.app.Styles
import javafx.geometry.Pos
import javafx.scene.paint.Color
import tornadofx.*

class SignUpView : View("Welcome to Book Store!") {
    override val root = borderpane {
        top = button("< Back") {
            style {
                textFill = Color.GRAY
            }
            alignment = Pos.TOP_LEFT
            action {
                replaceWith<LoginView>(sizeToScene = true)
            }
        }
        center = form {
            form {
                addClass(Styles.loginScreen)
                fieldset("Personal Info") {
                    field("First name") {
                        textfield()
                    }

                    field("Last name") {
                        textfield()
                    }

                    field("Birth Date") {
                        datepicker()
                    }
                }

                fieldset("Contact") {
                    field("Email") {
                        textfield()
                    }

                    field("Phone") {
                        textfield()
                    }

                    field("City") {
                        textfield()
                    }

                    field("Address") {
                        textfield()
                    }

                }

                button("Create account") {
                    alignment = Pos.BOTTOM_CENTER
                    style {
                        backgroundColor += Color.DODGERBLUE
                        textFill = Color.WHITE
                    }
                }

            }
        }
    }

}
