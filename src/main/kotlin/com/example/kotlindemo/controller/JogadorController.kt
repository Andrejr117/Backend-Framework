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

    @GetMapping("/jogador/{jogador}")
    fun getJogadorById(@PathVariable(value = "idJogador") jogadorId: Long): ResponseEntity<Jogador> {
        return jogadorRepository.findById(jogadorId).map { jogador ->
            ResponseEntity.ok(jogador)
        }.orElse(ResponseEntity.notFound().build())
    }


    @PutMapping("/jogador/{idJogador}")
    fun updateJogadorById(
        @PathVariable(value = "idJogador") jogadorId: Long,
        @Valid @RequestBody newJogador: Jogador
    ): ResponseEntity<Jogador> {

        return jogadorRepository.findById(jogadorId).map { existingJogador ->
            val updatedJogador: Jogador = existingJogador
                .copy(
                    jogadorid = newJogador.jogadorid,
                    email = newJogador.email,
                    nome = newJogador.nome,
                    senha = newJogador.senha,
                    endereco = newJogador.endereco,
                    nacionalidade = newJogador.nacionalidade,
                    posicao = newJogador.posicao,
                    peDominante = newJogador.peDominante,
                    altura = newJogador.altura,

                    )
            ResponseEntity.ok().body(jogadorRepository.save(updatedJogador))
        }.orElse(ResponseEntity.notFound().build())
    }


    @DeleteMapping("/jogador/{idJogador}")
    fun deletarJogadorById(@PathVariable(value = "idJogador") jogadorId: Long): ResponseEntity<Void> {
        return jogadorRepository.findById(jogadorId).map { jogador ->
            jogadorRepository.delete(jogador)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/jogador/{idJogador}")
    fun infoPerfilJogador(@PathVariable (value = "idJogador") jogadorId: Long): Jogador? {
        val jogador = jogadorRepository.findById(jogadorId)
        println("Informações do jogador:")
        jogador.ifPresent { println(" Nome: ${it.nome}, Posição: ${it.posicao}, Altura: ${it.altura}, " +
                "Pé Dominante: ${it.peDominante}, Naciolnalidade : ${it.nacionalidade}") }
        return jogador.orElse(null)

    }

    @PutMapping("/jogador/{idJogador}/alterar-senha")
    fun alterarSenha(@PathVariable (value = "idJogador") jogadorId: Long, @RequestBody novaSenha: Integer): ResponseEntity<String> {
        val jogadorOptional = jogadorRepository.findById(jogadorId)

        if (jogadorOptional.isPresent) {
            val jogador = jogadorOptional.get()
            jogador.senha = novaSenha
            jogadorRepository.save(jogador)

            return ResponseEntity.ok("Senha alterada com sucesso para o jogador de ID ${jogador.nome}.")
        }

        return ResponseEntity.notFound().build()
    }

}


