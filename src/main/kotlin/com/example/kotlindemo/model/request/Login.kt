package com.example.kotlindemo.model.request

data class Login(
    val email: String?,
    val jogadorId: Long?,
    val senha: Integer
)