package com.example.kotlindemo.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.context.annotation.Lazy
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Lazy
@Entity
data class Jogador(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val jogadorid: Long = 0,

    @get: NotBlank
    var email: String,

    @get: NotBlank
    var nome: String,

    @JsonIgnore
    @get: NotBlank
    var senha: Integer,

    @get: NotBlank
    var nacionalidade: String,

    @get: NotBlank
    var posicao: String,

    @get: NotBlank
    var peDominante: String,

    @get: NotBlank
    var altura: String,

    @OneToOne
    @JoinColumn(name = "endereco_id")
    var endereco: Endereco,

    @ManyToOne
    @JoinColumn(name = "sala_id")
    var sala: Sala? = null


)
