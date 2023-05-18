package com.example.kotlindemo.controller
import Jogador
import Sala
import com.example.kotlindemo.repository.JogadorRepository
import com.example.kotlindemo.repository.SalaRepository
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


    @PostMapping("/sala")
    fun createNewSala(@Valid @RequestBody sala: Sala): Sala =
        salaRepository.save(sala)


    @GetMapping("/sala/{idSala}")
    fun getSalaById(@PathVariable(value = "idSala") salaId: Long):
            ResponseEntity<Sala> {
        return salaRepository.findById(salaId).map { sala ->
            ResponseEntity.ok(sala)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/sala/{idSala}")
    fun updateSalaById(@PathVariable(value = "idSala") salaId: Long,
                           @Valid @RequestBody newSala: Sala): ResponseEntity<Sala> {

        return salaRepository.findById(salaId).map { existingSala ->
            val updateSala: Sala = existingSala
                .copy(
                    salaId = newSala.salaId,
                    numeroSala = newSala.numeroSala,
                    jogadores = newSala.jogadores
                )
            ResponseEntity.ok().body(salaRepository.save(updateSala))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/sala/{idSala}")
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

    @DeleteMapping("/{salaId}/jogadores/{jogadorId}")
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

}