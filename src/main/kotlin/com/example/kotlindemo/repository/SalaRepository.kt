package com.example.kotlindemo.repository

import com.example.kotlindemo.model.Sala
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface SalaRepository : JpaRepository<Sala, Long>{
    fun findByNumeroSala(numeroSala: Int): Sala?
}
