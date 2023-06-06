package com.example.kotlindemo.model.request

import com.example.kotlindemo.model.Jogador

data class EntrarNaSalaRequest(
    val numeroSala: Int,
    val jogador: Jogador
)