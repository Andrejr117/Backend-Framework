package com.example.kotlindemo.repository

import com.example.kotlindemo.model.Jogador
import com.example.kotlindemo.model.Sala
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface JogadorRepository : JpaRepository<Jogador, Long>{
    fun findByEmail(Email: String): Jogador?
    fun findBySala(sala: Sala): List<Jogador>
}