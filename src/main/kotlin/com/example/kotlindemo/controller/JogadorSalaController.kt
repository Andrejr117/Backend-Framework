package com.example.kotlindemo.controller

import com.example.kotlindemo.repository.JogadorRepository
import com.example.kotlindemo.repository.SalaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.server.ResponseStatusException

class JogadorSalaController {
    @PostMapping("/jogadores/{idJogador}/salas/{idSala}")
    fun <JogadorSala : Any?> adicionarJogadorSala(
        @PathVariable jogadorId: Long,
        @PathVariable salaId: Long
    ): ResponseEntity<JogadorSala> {
        val jogador = jogadorRepository.findById(jogadorId)
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "Jogador não encontrado") }
        val sala = salaRepository.findById(salaId)
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "Sala não encontrada") }
        val jogadorSala = JogadorSala(jogador, sala)
        val jogadorSalaSalvo = jogadorSala.save(jogadorSala)
        return ResponseEntity.ok(jogadorSalaSalvo)
    }


    @DeleteMapping("/jogadores/{idJogador}/salas/{idSala}")
    fun removerJogadorSala(
        @PathVariable jogadorId: Long,
        @PathVariable salaId: Long
    ): ResponseEntity<Unit> {
        val jogador = jogadorRepository.findById(jogadorId)
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "Jogador não encontrado") }
        val sala = salaRepository.findById(salaId)
            .orElseThrow { throw ResponseStatusException(HttpStatus.NOT_FOUND, "Sala não encontrada") }
        val jogadorSala = jogadorSalaRepository.findByJogadorAndSala(jogador, sala)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Relacionamento entre jogador e sala não encontrado")
        jogadorSalaRepository.delete(jogadorSala)
        return ResponseEntity.noContent().build()
    }
    @GetMapping("/jogadores-salas")
    fun listarJogadoresSalas(): ResponseEntity<List<JogadorSala>> {
        val jogadoresSalas = jogadorSalaRepository.findAll()
        return ResponseEntity.ok(jogadoresSalas)
    }
}