import com.example.kotlindemo.model.JogadorSala
import javax.persistence.*
import javax.validation.constraints.NotBlank
@Entity

data class Sala(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val salaId: Long? = null,
    @get: NotBlank

    val numeroSala: Int,

    @OneToMany(mappedBy = "sala")
    val jogadores: MutableList<Jogador> = mutableListOf(),

    )

