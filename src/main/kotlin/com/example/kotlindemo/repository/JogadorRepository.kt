package com.example.kotlindemo.repository

import com.example.kotlindemo.model.ArticleJogador
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface JogadorRepository : JpaRepository<ArticleJogador, Long>