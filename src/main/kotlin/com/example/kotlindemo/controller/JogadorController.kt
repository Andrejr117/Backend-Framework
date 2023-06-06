package com.example.kotlindemo.controller


import com.example.kotlindemo.model.Jogador
import com.example.kotlindemo.model.request.Login
import com.example.kotlindemo.repository.JogadorRepository
import com.example.management.model.response.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid


@RestController
@RequestMapping("/api")
class JogadorController
    (private val jogadorRepository: JogadorRepository) {

    @PostMapping("/jogador")
    fun criarNovoJogador(@Valid @RequestBody jogador: Jogador): Jogador =
        jogadorRepository.save(jogador)

    @GetMapping("/jogador/{idJogador}")
    fun getJogadorById(@PathVariable(value = "idJogador") jogadorId: Long): ResponseEntity<Jogador> {
        return jogadorRepository.findById(jogadorId).map { jogador ->
            ResponseEntity.ok(jogador)
        }.orElse(ResponseEntity.notFound().build())
    }


    @PutMapping("/atualizarjogador/{idJogador}")
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
                    nacionalidade = newJogador.nacionalidade,
                    posicao = newJogador.posicao,
                    peDominante = newJogador.peDominante,
                    altura = newJogador.altura,
                    endereco = newJogador.endereco

                    )
            ResponseEntity.ok().body(jogadorRepository.save(updatedJogador))
        }.orElse(ResponseEntity.notFound().build())
    }


    @DeleteMapping("/deletejogador/{idJogador}")
    fun deletarJogadorById(@PathVariable(value = "idJogador") jogadorId: Long): ResponseEntity<Void> {
        return jogadorRepository.findById(jogadorId).map { jogador ->
            jogadorRepository.delete(jogador)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

    @GetMapping("/infojogador/{idJogador}")
    fun infoPerfilJogador(@PathVariable (value = "idJogador") jogadorId: Long): Jogador? {
        val jogador = jogadorRepository.findById(jogadorId)
        println("Informações do jogador:")
        jogador.ifPresent { println(" Nome: ${it.nome}, Posição: ${it.posicao}, Altura: ${it.altura}, " +
                "Pé Dominante: ${it.peDominante}, Naciolnalidade : ${it.nacionalidade}") }
        return jogador.orElse(null)

    }

    @PutMapping("/alterarsenha/{idJogador}")
    fun alterarSenha(@PathVariable (value = "idJogador") jogadorId: Long, @RequestBody novaSenha: Int): ResponseEntity<String> {
        val jogadorOptional = jogadorRepository.findById(jogadorId)

        if (jogadorOptional.isPresent) {
            val jogador = jogadorOptional.get()
            jogador.senha = novaSenha
            jogadorRepository.save(jogador)

            return ResponseEntity.ok("Senha alterada com sucesso para o jogador de ID ${jogador.jogadorid}.")
        }

        return ResponseEntity.notFound().build()
    }


    @PostMapping("/login")
    fun login(@Valid @RequestBody login: Login): ResponseEntity<BaseResponse<Jogador?>> {
        val gerente = login.email?.let {
            jogadorRepository.findByEmail(it)
        } ?: run {
            login.jogadorId?.let {
                this.getJogadorById(login.jogadorId).body
            }
        }
        gerente?.let { gerente ->
            if (login.senha == gerente.senha) {
                return BaseResponse.createResponse(
                    isError = false,
                    data = gerente,
                    code = HttpStatus.OK
                )
            } else {
                return BaseResponse.createResponse()
            }
        } ?: run {
            return BaseResponse.createResponse()
        }
    }

}