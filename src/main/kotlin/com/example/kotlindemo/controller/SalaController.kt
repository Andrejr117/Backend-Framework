package com.example.kotlindemo.controller

import com.example.kotlindemo.model.Jogador
import com.example.kotlindemo.model.Sala
import com.example.kotlindemo.model.request.EquipeJogadores
import com.example.kotlindemo.repository.SalaRepository
import com.example.kotlindemo.repository.JogadorRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class SalaController(
    private val salaRepository: SalaRepository,
    private val jogadorRepository: JogadorRepository
) {

    @GetMapping("/sala")
    fun getSala(): List<Sala> =
        salaRepository.findAll()


    @PostMapping("/criarsala")
    fun createNewSala(@Valid @RequestBody sala: Sala): Sala =
        salaRepository.save(sala)


    @GetMapping("/sala/{idSala}")
    fun getSalaById(@PathVariable(value = "idSala") salaId: Long):
            ResponseEntity<Sala> {
        return salaRepository.findById(salaId).map { sala ->
            ResponseEntity.ok(sala)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/atualizarsala/{idSala}")
    fun updateSalaById(@PathVariable(value = "idSala") salaId: Long,
                           @Valid @RequestBody newSala: Sala): ResponseEntity<Sala> {

        return salaRepository.findById(salaId).map { existingSala ->
            val updateSala: Sala = existingSala
                .copy(
                    salaId = newSala.salaId,
                    numeroSala = newSala.numeroSala
                )
            ResponseEntity.ok().body(salaRepository.save(updateSala))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/deletesala/{idSala}")
    fun deleteSalaById(@PathVariable(value = "idSala") salaId: Long): ResponseEntity<Void> {
        return salaRepository.findById(salaId).map { sala  ->
            salaRepository.delete(sala)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }

    @PostMapping("/sala/{idSala}/jogadores")
    fun adicionarJogadorNaSala(@PathVariable (value = "idSala")salaId: Long, @RequestBody jogador: Jogador): ResponseEntity<String> {
        val salaOptional = salaRepository.findById(salaId)

        if (salaOptional.isPresent) {
            val sala = salaOptional.get()


            if (jogador.sala != null) {
                return ResponseEntity.badRequest().body("O jogador já está em uma sala.")
            }

            jogador.sala = sala
            jogadorRepository.save(jogador)

            return ResponseEntity.ok("Jogador adicionado à sala com sucesso.")
        }

        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("/sala/{salaId}/jogadores/{jogadorId}")
    fun removerJogadorDaSala(@PathVariable (value ="salaId")salaId: Long, @PathVariable jogadorId: Long): ResponseEntity<String> {
        val salaOptional = salaRepository.findById(salaId)

        if (salaOptional.isPresent) {
            val sala = salaOptional.get()

            val jogadorOptional = jogadorRepository.findById(jogadorId)

            if (jogadorOptional.isPresent) {
                val jogador = jogadorOptional.get()

                if (jogador.sala?.salaId == salaId) {
                    jogador.sala = null
                    jogadorRepository.save(jogador)

                    return ResponseEntity.ok("Jogador removido da sala com sucesso.")
                }

                return ResponseEntity.badRequest().body("O jogador não está na sala informada.")
            }

            return ResponseEntity.notFound().build()
        }

        return ResponseEntity.notFound().build()
    }

    @GetMapping("/sala/{idSala}/jogadores")
    fun getJogadoresDaSala(@PathVariable(value = "idSala") salaId: Long): ResponseEntity<List<Jogador>> {
        val salaOptional = salaRepository.findById(salaId)

        if (salaOptional.isPresent) {
            val sala = salaOptional.get()
            val jogadores = jogadorRepository.findBySala(sala)
            return ResponseEntity.ok(jogadores)
        }

        return ResponseEntity.notFound().build()
    }

    @PostMapping("/sala/{idSala}/sorteiotimes")
    fun sortearTimes(@PathVariable(value = "idSala") salaId: Long): ResponseEntity<String> {
        val salaOptional = salaRepository.findById(salaId)

        if (salaOptional.isPresent) {
            val sala = salaOptional.get()
            val jogadores = sala.jogadores

            if (jogadores.size < 2) {
                return ResponseEntity.badRequest().body("É necessário ter pelo menos 2 jogadores para realizar o sorteio de times.")
            }

            val totalJogadores = jogadores.size
            val meio = totalJogadores / 2

            jogadores.shuffle()

            val equipe1: List<Jogador>
            val equipe2: List<Jogador>

            if (totalJogadores % 2 == 0) {
                equipe1 = jogadores.subList(0, meio)
                equipe2 = jogadores.subList(meio, totalJogadores)
            } else {
                equipe1 = jogadores.subList(0, meio + 1)
                equipe2 = jogadores.subList(meio + 1, totalJogadores)
            }

            equipe1.forEach { jogador ->
                jogador.equipe = "Equipe 1"
                jogadorRepository.save(jogador)
            }

            equipe2.forEach { jogador ->
                jogador.equipe = "Equipe 2"
                jogadorRepository.save(jogador)
            }

            // Salve as equipes nos parâmetros equipe1 e equipe2 da sala
            sala.equipe1 = "Equipe 1"
            sala.equipe2 = "Equipe 2"
            salaRepository.save(sala)

            return ResponseEntity.ok().body("Sorteio de times realizado com sucesso.")
        }

        return ResponseEntity.notFound().build()
    }

    @GetMapping("/sala/{idSala}/equipes")
    fun listarEquipes(@PathVariable(value = "idSala") salaId: Long): ResponseEntity<List<EquipeJogadores>> {
        val salaOptional = salaRepository.findById(salaId)

        if (salaOptional.isPresent) {
            val sala = salaOptional.get()

            val equipe1Nome = sala.equipe1
            val equipe2Nome = sala.equipe2

            if (equipe1Nome != null && equipe2Nome != null) {
                val equipe1Jogadores = jogadorRepository.findJogadoresByEquipe(equipe1Nome)
                val equipe2Jogadores = jogadorRepository.findJogadoresByEquipe(equipe2Nome)

                val equipe1 = EquipeJogadores(equipe1Nome, equipe1Jogadores)
                val equipe2 = EquipeJogadores(equipe2Nome, equipe2Jogadores)

                val equipes = listOf(equipe1, equipe2)

                return ResponseEntity.ok(equipes)
            }
        }

        return ResponseEntity.notFound().build()
    }

}