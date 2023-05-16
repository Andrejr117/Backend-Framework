package com.example.kotlindemo.controller

import Jogador
import com.example.kotlindemo.repository.JogadorRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.persistence.Entity
import javax.validation.Valid


@RestController
@RequestMapping("/api")
@Entity


class JogadorController
    (private val jogadorRepository: JogadorRepository) {

    @GetMapping("/jogador")
    fun getjogador(): List<Jogador> =
        jogadorRepository.findAll()

    @PostMapping("/jogador")
    fun criarNovoJogador(@Valid @RequestBody jogador: Jogador): Jogador =
        jogadorRepository.save(jogador)

    @GetMapping("/jogador/{jogadorid}")
    fun getJogadorById(@PathVariable(value = "jogadorid") jogadorId: Long): ResponseEntity<Jogador> {
        return jogadorRepository.findById(jogadorId).map { jogador ->
            ResponseEntity.ok(jogador)
        }.orElse(ResponseEntity.notFound().build())
    }


    @PutMapping("/jogador/{id}")
    fun updateJogadorById(
        @PathVariable(value = "Jogador") Jogador: Long,
        @Valid @RequestBody newJogador: Jogador
    ): ResponseEntity<Jogador> {

        return jogadorRepository.findById(Jogador).map { existingJogador ->
            val updatedJogador: Jogador = existingJogador
                .copy(
                    jogadorid = newJogador.jogadorid,
                    email = newJogador.email,
                    nome = newJogador.nome,
                    senha = newJogador.senha,
                    endereco = newJogador.endereco,
                    nacionalidade = newJogador.nacionalidade,
                    posicao = newJogador.posicao,
                    pe_dominante = newJogador.pe_dominante,
                    altura = newJogador.altura,

                    )
            ResponseEntity.ok().body(jogadorRepository.save(updatedJogador))
        }.orElse(ResponseEntity.notFound().build())
    }


    @DeleteMapping("/Jogador/{id}")
    fun deletarJogadorById(@PathVariable(value = "id") JogadorId: Long): ResponseEntity<Void> {
        return jogadorRepository.findById(JogadorId).map { jogador ->
            jogadorRepository.delete(jogador)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun alterarSenha(@PathVariable  jogadorId: Long, novaSenha: Integer, confirmacaoSenha: Integer): Boolean {

        if (novaSenha != confirmacaoSenha) {
            return false
        }

        val jogador = jogadorRepository.findById(jogadorId)

        if (jogador == null){
            return false
        }

        jogador.senha = novaSenha

        jogadorRepository.save(jogador)
        return true   }

    fun exibirPerfilJogador(jogadorId: Long) {
        val jogador = Jogador.Companion.getJogadorById(jogadorId)
        val perfilJogador = (jogadorId)

        if (perfilJogador != null) {
            println("Nome: ${perfilJogador}")
            println("${perfilJogador.}")
            println("${perfilJogador.}")
            println("${perfilJogador.}")
            println("${perfilJogador.}")
        }

    }

}


