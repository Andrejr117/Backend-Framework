package com.example.kotlindemo.repository

import Sala
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface SalaRepository : JpaRepository<Sala, Long>{
    fun getSalaByJogador(sala: Sala): List<Sala>?

}