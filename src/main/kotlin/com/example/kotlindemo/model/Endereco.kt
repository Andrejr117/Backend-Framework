package com.example.kotlindemo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank



@Entity
data class Endereco (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val enderecoId: Long = 0,
    @get: NotBlank
    val endereco: String,
    @get: NotBlank
    val bairro: String,
    @get: NotBlank
    val rua: String,
    @get: NotBlank
    val numero: String
)
