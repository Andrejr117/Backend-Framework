import javax.persistence.*
import javax.validation.constraints.NotBlank
@Entity

data class Sala(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val salaId: Long = 0,
    @get: NotBlank

    val numeroSala: Int,

    @OneToMany(targetEntity = Jogador::class)
    val jogadores: List<Jogador>,

    )

