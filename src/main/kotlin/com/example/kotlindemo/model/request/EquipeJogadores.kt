package com.example.kotlindemo.model.request

import com.example.kotlindemo.model.Jogador

data class EquipeJogadores(
    val nomeEquipe: String,
    val jogadores: List<Jogador>
)