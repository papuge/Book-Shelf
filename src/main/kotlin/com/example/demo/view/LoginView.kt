package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.UserController
import com.example.demo.model.UserModel
import javafx.geometry.Point2D
import javafx.geometry.Pos
import tornadofx.*
import javafx.scene.paint.Color
import javafx.scene.text.FontPosture
import javafx.util.Duration

class LoginView : View("Welcome to Book Store!") {

    private val loginController: UserController by inject()
    private val model: UserModel by inject()

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
                    textfield(model.username).required()
                }

                field("Password") {
                    addClass(Styles.loginScreen)
                    passwordfield(model.password) {
                        required()
                    }
                }
            }

            vbox(20) {
                alignment = Pos.CENTER
                button("Sign in") {
                    enableWhen(model.valid)
                    style {
                        textFill = Color.DARKBLUE
                        fontSize = 15.px
                    }
                    action {
                        if (loginController.authenticate(model.username.value,
                                        model.password.value))
                            replaceWith<TabbedMenuView>(sizeToScene = true)
                        else
                            find<InvalidLoginView>().openModal()
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
        model.validate(decorateErrors = false)
        if (loginController.autoLogin())
            replaceWith<TabbedMenuView>(sizeToScene = true)
    }

    fun clean() {
        model.username.value = ""
        model.password.value = ""
    }
}

class InvalidLoginView: Fragment() {
    override val root = label("Invalid username or password!") {
        alignment = Pos.CENTER
        style {
            textFill = Color.RED
            fontSize = 18.px
        }
    }
}