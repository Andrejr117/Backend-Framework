import com.example.kotlindemo.model.JogadorSala
import javax.persistence.*
import javax.validation.constraints.NotBlank
@Entity

data class Sala<JogadorSala>(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val salaId: Long = 0,
    @get: NotBlank

    val numeroSala: Int,

    @OneToMany(mappedBy = "sala")
    var jogadores: List<JogadorSala> = emptyList(),

    )

