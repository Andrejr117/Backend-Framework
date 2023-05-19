package com.example.kotlindemo.model

import Jogador
import org.springframework.context.annotation.Lazy
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Lazy
@Entity
data class Endereco (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val enderecoId: Long = 0,
    @get: NotBlank
    val nomeEndereco: String,

    @OneToOne
    @JoinColumn(name = "jogador_id")
    val jogador: Jogador

)
