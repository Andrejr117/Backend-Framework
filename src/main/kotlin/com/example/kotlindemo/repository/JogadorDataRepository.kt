package com.example.kotlindemo.repository

import Jogador

abstract class JogadorDataRepository: JogadorRepository {
    override fun getJogadorById(jogadorId: Long): Jogador? {
        findById(jogadorId)

        return TODO("Provide the return value")
    }

}