package com.example.demo.controller.chainOfRHandlers

interface Handler {
    fun setNext(h: Handler)
    fun handle()
}