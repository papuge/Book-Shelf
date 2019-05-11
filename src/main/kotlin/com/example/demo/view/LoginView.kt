package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.UserController
import javafx.geometry.Point2D
import javafx.geometry.Pos
import tornadofx.*
import javafx.scene.paint.Color
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.util.Duration
import java.awt.Font

class LoginView : View("Welcome to Book Store!") {

    private val loginController: UserController by inject()

    override val root = hbox {
        this.alignment = Pos.CENTER
        form {
            alignment = Pos.CENTER
            fieldset("Login") {
                style {
                    fontSize = 22.px
                    alignment = Pos.CENTER
                }
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
                        scale(Duration(400.0), Point2D(1.5, 1.5))
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
                        scale(Duration(400.0), Point2D(1.5, 1.5))
                        replaceWith<SignUpView>(sizeToScene = true)
                    }
                }

            }

        }
    }

//    override fun onDock() {
//        with(root) {
//            resize(250.0, 300.0)
//        }
//    }
}