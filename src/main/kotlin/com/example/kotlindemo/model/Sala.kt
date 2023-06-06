package com.example.kotlindemo.model

import org.springframework.context.annotation.Lazy
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Lazy
@Entity
data class Sala(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val salaId: Long? = null,

    @get: NotNull
    var numeroSala: Int,

    var equipe1: String?,

    var equipe2: String?,

    @OneToMany(mappedBy = "sala")
    var jogadores: MutableList<Jogador> = ArrayList()

)

