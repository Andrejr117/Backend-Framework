package com.example.kotlindemo.repository

import com.example.kotlindemo.model.Jogador
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface JogadorRepository : JpaRepository<Jogador, Long>{
    fun findJogadorByEmail(Email: String): Jogador?
}