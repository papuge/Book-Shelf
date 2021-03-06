package com.example.demo.app

import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val tabName by cssclass()
        val loginScreen by cssclass()
        val basketItems by cssclass()
    }

    init {
        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.MEDIUM
        }

        tabName {
            alignment = Pos.TOP_CENTER
            maxWidth = infinity
            fillWidth = true
            fontWeight = FontWeight.BOLD
            fontFamily = "Noto Sans Medium"
            fontSize = 32.px
        }

        loginScreen {
            label {
                padding = box(12.px)
                fontFamily = "Libre Sans"
                fontWeight = FontWeight.BOLD
                fontSize = 15.px
            }
            padding = box(12.px)
            fontFamily = "Libre Sans"
            fontSize = 15.px
        }

        basketItems {
            label {
                padding = box(12.px)
                fontFamily = "Libre Sans"
                fontSize = 15.px
            }
            button {
                prefWidth = 35.px
                prefHeight = 35.px
                backgroundColor += Color.AZURE
                textFill = Color.SLATEGRAY
            }
        }
    }
}