package com.example.kotlindemo.controller
import Sala
import com.example.kotlindemo.repository.SalaRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class SalaController(
    private val salaRepository: SalaRepository
) {

    @GetMapping("/sala")
    fun getSala(): List<Sala> =
        salaRepository.findAll()


    @PostMapping("/sala")
    fun createNewSala(@Valid @RequestBody sala: Sala): Sala =
        salaRepository.save(sala)


    @GetMapping("/sala/{salaId}")
    fun getSalaById(@PathVariable(value = "salaId") salaId: Long):
            ResponseEntity<Sala> {
        return salaRepository.findById(salaId).map { sala ->
            ResponseEntity.ok(sala)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/sala/{salaId}")
    fun updateSalaById(@PathVariable(value = "salaId") salaId: Long,
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

    @DeleteMapping("/sala/{salaId}")
    fun deleteSalaById(@PathVariable(value = "salaId") salaId: Long): ResponseEntity<Void> {

        return salaRepository.findById(salaId).map { sala  ->
            salaRepository.delete(sala)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }

}