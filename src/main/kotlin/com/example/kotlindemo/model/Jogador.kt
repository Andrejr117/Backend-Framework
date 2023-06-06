package com.example.kotlindemo.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.context.annotation.Lazy
import javax.persistence.*
import javax.validation.constraints.*


@Entity
data class Jogador(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var jogadorid: Long = 0,

    @get: NotBlank
    var email: String,

    @get: NotBlank
    var nome: String,

    @JsonIgnore
    @NotNull
    var senha: Int?,

    @get: NotBlank
    var nacionalidade: String,

    @get: NotBlank
    var posicao: String,

    @get: NotBlank
    var peDominante: String,

    @get: NotNull
    var altura: Double,


    @OneToOne
    @JoinColumn(name = "endereco_id")
    var endereco: Endereco? = null,

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sala_id")
    var sala: Sala? = null,

    @JsonIgnore
    var equipe: String? = null,



    )
