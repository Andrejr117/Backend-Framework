package com.example.kotlindemo.model

import Jogador
import Sala
import javax.persistence.*

@Entity
data class JogadorSala(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    var jogador: Jogador,
    @ManyToOne(fetch = FetchType.LAZY)
    var sala: Sala

) {

}
