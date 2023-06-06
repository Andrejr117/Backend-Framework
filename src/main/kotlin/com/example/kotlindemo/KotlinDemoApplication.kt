package com.example.kotlindemo

import com.example.kotlindemo.model.Jogador
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
@SpringBootApplication
class KotlinDemoApplicationApplication

fun main(args: Array<String>) {

    val novoJogador = Jogador(
        email = "jogador@example.com",
        nome = "João",
        senha = 123456,
        nacionalidade = "Brasil",
        posicao = "Atacante",
        peDominante = "Direito",
        altura = 1.80
    )



    runApplication<KotlinDemoApplicationApplication>(*args)
}



