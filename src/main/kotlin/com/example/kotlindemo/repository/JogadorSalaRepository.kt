package com.example.kotlindemo.repository

import Jogador
import Sala
import com.example.kotlindemo.model.JogadorSala
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JogadorSalaRepository : JpaRepository<JogadorSala, Long> {
    fun findByJogador(jogador: Jogador): List<JogadorSala>
    fun findBySala(sala: Sala): List<JogadorSala>
}