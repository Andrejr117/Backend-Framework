package com.example.kotlindemo.controller
import com.example.kotlindemo.repository.JogadorRepository
import com.example.kotlindemo.model.Article
import com.example.kotlindemo.model.ArticleJogador
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.persistence.Id;
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.DriverManager;

/**
 * Created by rajeevkumarsingh on 04/10/17.
 */
@RestController
@RequestMapping("/api")
@Entity
data class Jogador(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    @get: NotBlank
    val email: String,
    @get: NotBlank
    val nome: String,
    @get: NotBlank
    val senha: Integer,
    @get: NotBlank
    val endereco: String,
    @get: NotBlank
    val nacionalidade: String,
    @get: NotBlank
    val posicao: String,
    @get: NotBlank
    val pe_dominante: String,
    @get: NotBlank
    val altura: String,
)
class JogadorController(private val jogadorRepository: JogadorRepository) {

    @GetMapping("/jogador")
    fun getAlljogador(): List<jogador> =
        jogadorRepository.findAll()

    @PostMapping("/jogador")
    fun criarNovoJogador(@Valid @RequestBody Jogador: Jogador): Jogador =
        jogadorRepository.save(jogador)

    @GetMapping("/jogador/{id}")
    fun getJogadorById(@PathVariable(value = "id") jogadorId: Long): ResponseEntity<Jogador> {
        return jogadorRepository.findById(jogadorId).map { jogador ->
            ResponseEntity.ok(jogador)
        }.orElse(ResponseEntity.notFound().build())
    }


    @PutMapping("/articles/{id}")
    fun atualizarJogadorById(@PathVariable(value = "id") jogadorId: Long,
                          @Valid @RequestBody novoJogador: Jogador): ResponseEntity<Jogador> {

        return jogadorRepository.findById(jogadorId).map { existeJogador ->
            val atualizarJogador: Jogador = existeJogador
                .copy(title = novoJogador.title, content = NovoJogador()Jogador.content)

            ResponseEntity.ok().body(jogadorRepository.save(atualizarJogador))
        }.orElse(ResponseEntity.notFound().build())

    }
    @DeleteMapping("/Jogador/{id}")
    fun deletarJogadorById(@PathVariable(value = "id") JogadorId: Long): ResponseEntity<Jogador> {

        return jogadorRepository.findById(JogadorId).map { Jogador  ->
            jogadorRepository.delete(Jogador)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
    fun recuperarsenha(email: String, novaSenha: Interger, confirmarSenha: Interger): Boolean{
         // logica para verificar se o usuario e a senha atual é valida
        if(verificarEmail == true){
          //logica para alterar a senha
        buscarSenhaPorEmail(email)
        }
        return false
        //falha ao alterar senha
    }

    fun buscarSenhaPorEmail(email: String): String? {
        val url = "jdbc:mysql://MarcinhoRox:3306/profut"
        val username = "root"
        val password = "1992"

        var senha: Interger? = null

        DriverManager.getConnectçion(url, email, senha).use { conn ->
            conn.prepareStatement("SELECT senha FROM jogador WHERE email = ?").use { stmt ->
                stmt.setString(1, email)
                val rs = stmt.executeQuery()
                if (rs.next()) {
                    senha = rs.getString("senha")
                }
            }
        }

        return senha
    }


    fun verificarEmail(email: String): Boolean {
        Database.connect("jdbc:mysql://MarcinhoRox:3306/profut", driver = "com.mysql.jdbc.Driver", user = "root", password = "1992")

        var emailEncontrado = false

        transaction {
            val resultado = Jogador.select { Jogador.email eq email }.toList()
            if (resultado.isNotEmpty()) {
                emailEncontrado = true
            }
        }

        return emailEncontrado
    }

    fun exibirListaJogadores(jogadores: List<Jogador>) {
        for (jogador in jogadores) {
            println("Id: ${jogador.id}, Email: ${jogador.email}, Nome: ${jogador.nome}, Senha: ${jogador.senha}," +
                    " Endereço: ${jogador.endereco}, Nacionalidade: ${jogador.nacionalidade}, Posição: ${jogador.posicao}" +
                    " Pé Dominante: ${jogador.pe_dominante}, Altura: ${jogador.altura})
             //A função exibirListaJogadores recebe a lista de jogadores como parâmetro e itera sobre
            // ela usando um loop for. Para cada jogador, imprime na tela seu nome, idade e posição.
        }
    }

}