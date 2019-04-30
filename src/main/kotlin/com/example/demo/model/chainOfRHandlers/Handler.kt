package com.example.demo.model.chainOfRHandlers

interface Handler {
    fun setNext(h: Handler)
    fun handle()
}