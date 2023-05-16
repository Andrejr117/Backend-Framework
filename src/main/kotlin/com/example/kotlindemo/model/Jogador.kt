import com.example.kotlindemo.model.JogadorSala
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.validation.constraints.NotBlank
@Entity
data class Jogador(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val jogadorid: Long = 0,
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
    val altura: String
    )

@OneToMany(mappedBy = "jogador")
var sala: List<JogadorSala> = emptyList()