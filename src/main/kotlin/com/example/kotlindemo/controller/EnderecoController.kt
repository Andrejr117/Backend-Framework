package com.example.kotlindemo.controller

import com.example.kotlindemo.model.Endereco
import com.example.kotlindemo.repository.EnderecoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/api")
data class EnderecoController(
    private val enderecoRepository: EnderecoRepository
) {

    @GetMapping("/endereco")
    fun getEndereco(): List<Endereco> =
        enderecoRepository.findAll()


    @PostMapping("/endereco")
    fun createNewEndereco(@Valid @RequestBody endereco: Endereco): Endereco =
        enderecoRepository.save(endereco)


    @GetMapping("/endereco/{idEndereco}")
    fun getEnderecoById(@PathVariable(value = "idEndereco") enderecoId: Long):
            ResponseEntity<Endereco> {
        return enderecoRepository.findById(enderecoId).map { gerente ->
            ResponseEntity.ok(gerente)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/endereco/{idEndereco}")
    fun updateEnderecoById(@PathVariable(value = "idEndereco") enderecoId: Long,
                          @Valid @RequestBody newEndereco: Endereco): ResponseEntity<Endereco> {

        return enderecoRepository.findById(enderecoId).map { existingEndereco ->
            val updateEndereco: Endereco = existingEndereco
                .copy(
                    enderecoId = newEndereco.enderecoId,
                    endereco = newEndereco.endereco,
                    bairro = newEndereco.bairro,
                    rua = newEndereco.rua,
                    numero = newEndereco.numero
                )
            ResponseEntity.ok().body(enderecoRepository.save(updateEndereco))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/endereco/{idEndereco}")
    fun deleteEnderecoById(@PathVariable(value = "idEndereco") enderecoId: Long): ResponseEntity<Void> {

        return enderecoRepository.findById(enderecoId).map { endereco  ->
            enderecoRepository.delete(endereco)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }

}


