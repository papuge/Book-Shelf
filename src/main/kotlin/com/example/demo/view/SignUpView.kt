package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.UserController
import com.example.demo.model.UserModel
import javafx.geometry.Pos
import javafx.scene.paint.Color
import tornadofx.*

class SignUpView : View("Welcome to Book Store!") {

    private val model: UserModel by inject()
    private val controller: UserController by inject()

    override val root = borderpane {
        center = form {
            form {
                addClass(Styles.loginScreen)

                fieldset("Info / Contacts") {
                    field("Username") {
                        textfield(model.username).required()
                    }

                    field("Password") {
                        passwordfield(model.password) {
                            required()
                            validator {
                                if(it.isNullOrBlank()) null
                                else {
                                    if (it!!.length < 4) error("password min length: 4") else null
                                }
                            }
                        }
                    }

                    field("Email") {
                        textfield(model.email) {
                            required()
                            validator {
                                if(it.isNullOrBlank()) null
                                else {
                                    if (it!!.length < 4 || !it!!.contains("@"))
                                        error("invalid email") else null
                                }
                            }
                        }
                    }

                }

                button("Create account") {
                    alignment = Pos.BOTTOM_CENTER
                    style {
                        backgroundColor += Color.DODGERBLUE
                        textFill = Color.WHITE
                    }
                    action {
                        if (controller.register(model))
                            replaceWith<LoginView>(sizeToScene = true)
                        else
                            find<InvalidSignUpView>().openModal()
                    }
                }

            }
        }
    }

    override fun onDock() {
        model.validate(decorateErrors = false)
        model.username.value = ""
        model.password.value = ""
        model.email.value = ""
    }

}

class InvalidSignUpView: Fragment() {
    override val root = label("This user already exist!") {
        alignment = Pos.CENTER
        style {
            textFill = Color.RED
            fontSize = 18.px
        }
    }
}