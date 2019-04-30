package com.example.demo.view

import com.example.demo.app.Styles
import javafx.geometry.Pos
import tornadofx.*
import javafx.scene.paint.Color
import javafx.scene.text.FontPosture

class LoginView : View("Welcome to Book Store!") {
    override val root = hbox {
        this.alignment = Pos.CENTER
        form {
            alignment = Pos.CENTER
            fieldset("Login") {
//                style {
//                    fontSize = 22.px
//                }
                field("Username") {
                    addClass(Styles.loginScreen)
                    textfield()
                }

                field("Password") {
                    addClass(Styles.loginScreen)
                    passwordfield()
                }
            }

            vbox(20) {
                alignment = Pos.CENTER
                button("Sign in") {
                    style {
                        textFill = Color.DARKBLUE
                        fontSize = 15.px
                    }
                    action {
                        replaceWith<TabbedMenuView>(sizeToScene = true)
                    }
                }

                label("Don't have an account?") {
                    style {
                        fontStyle = FontPosture.ITALIC
                        fontSize = 15.px
                        textFill = Color.SLATEGRAY
                    }
                }

                button("Sign up") {
                    style {
                        backgroundColor += Color.DODGERBLUE
                        textFill = Color.WHITE
                        fontSize = 15.px
                    }
                    action {
                        replaceWith<SignUpView>(sizeToScene = true)
                    }
                }

            }

        }
    }

    override fun onDock() {
        with(root) {
            resize(250.0, 300.0)
        }
    }
}