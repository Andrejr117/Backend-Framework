import com.example.kotlindemo.model.JogadorSala
import javax.persistence.*
import javax.validation.constraints.NotBlank
@Entity
data class Jogador(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val jogadorid: Long = 0,
    @get: NotBlank
    var email: String,
    @get: NotBlank
    var nome: String,
    @get: NotBlank
    var senha: Integer,
    @get: NotBlank
    var endereco: String,
    @get: NotBlank
    var nacionalidade: String,
    @get: NotBlank
    var posicao: String,
    @get: NotBlank
    var peDominante: String,
    @get: NotBlank
    var altura: String,

    @ManyToOne
    @JoinColumn(name = "sala_id")
    var sala: Sala? = null

    )
