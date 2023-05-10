package com.example.kotlindemo.controller

import com.example.kotlindemo.model.Article
import com.example.kotlindemo.model.Endereco
import com.example.kotlindemo.repository.ArticleRepository
import com.example.kotlindemo.repository.EnderecoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

/**
 * Created by rajeevkumarsingh on 04/10/17.
 */

@RestController
@RequestMapping("/enderecos")
class EnderecoController(
    private val enderecoRepository: EnderecoRepository
) {
    @PostMapping
    fun criarEndereco(@RequesteBody endereco: Endereco): ResponseEntity<Endereco>{
        val novoEndereco = enderecoRepository.save(endereco)
        return  ResponseEntity,created("/enderecos/${novoEndereco.id}").body(novoEndereco)
    }
        //Nesse exemplo, o controlador define um método criarEndereco que recebe um objeto JSON de endereço no corpo da requisição
       // (usando a anotação @RequestBody) e usa o repositório do Spring Data JPA para salvar o novo endereço no banco de dados.
      // O método retorna uma resposta HTTP 201 (Created)
    }
    @GetMapping("/endereco/{id}")
    fun buscarEnderecoPorId(@PathVariable id: long):ResponseEntity <Endereco> {
        val endereco = buscarEnderecoPorId(id)
        return íf (endereco != null){
            @ResponseEntity.ok(endereco)
        } else {
            ResponseEntity.notFound().build()
//            Nesse exemplo, o controlador RESTful AddressController é anotado com @RestController e @RequestMapping("/addresses").
//            O método getAddressById é anotado com @GetMapping("/{id}") para mapear a rota /addresses/{id} com a função
//                    getAddressById. O parâmetro @PathVariable id é utilizado para obter o ID do endereço que será buscado.
//            Por fim, a função getAddressById é chamada a partir da instância de AddressService obtida por meio da injeção de
//            dependência do Spring. Se o endereço for encontrado, a função retorna uma resposta HTTP 200 OK com o objeto Address
//            encontrado. Caso contrário, a função retorna uma resposta HTTP 404 Not Found.

    }
    @PutMapping("/endereco/{id}")
    fun atualizarEnderecoById(@PathVariable(value = "id"),enderecoId: Long,
                              @valid @RequestBody newEndereco: Endereco): ResponseEntity<Endereço> {
        return enderecoRepository.findById(enderecoId).map { existingEndereco ->
            val atualizarEndereco: Endereco =
                existingEndereco.copy(title = newEndereco.title, content = newEndereco.content)
            ResponseEntity.ok().body(enderecoRepository.save(atualizarEndereco))
        }.orElse(ResponseEntity.notFount().build())
    }
        // Lógica para atualizar um endereço existente
        // Retorne um ResponseEntity com um código de status adequado e uma mensagem de sucesso

    }
    @DeleteMapping("/endereco/{id}")
    fun excluirEnderecoById(@PathVariable(value = "id") enderecoId: Long): ResponseEntity<Endereco> {
        return  EnderecoRepository.findById(enderecoId).map { endereco ->
            enderecoRepository.delete(endereco)
            ResponseEntity<endereco>(HttpStatus.Ok)
        }.orElse(ResponseEntity.notFound().build())
        // Lógica para excluir um endereço existente
        // Retorne um ResponseEntity com um código de status adequado e uma mensagem de sucesso
    }
}
