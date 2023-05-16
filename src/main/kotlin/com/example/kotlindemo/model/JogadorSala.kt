package com.example.kotlindemo.model

import javax.persistence.*

@Entity
data class JogadorSala<Jogador, Sala>(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    var jogador: Jogador,
    @ManyToOne(fetch = FetchType.LAZY)
    var sala: Sala

) {
    constructor(jogador: Jogador, sala: Sala);this(){
        this.jogador = jogador
        this.sala = sala
    }

}