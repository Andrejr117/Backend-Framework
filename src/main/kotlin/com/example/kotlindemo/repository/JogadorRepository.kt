package com.example.kotlindemo.repository

import Jogador
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface JogadorRepository : JpaRepository<Jogador, Long>