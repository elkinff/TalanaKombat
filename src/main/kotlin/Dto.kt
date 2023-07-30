data class Jugador(
    val movimientos: List<String>,
    val golpes: List<String>,
    val golpesEspeciales: List<Golpe>,
    val nombre: String,
    var energia: Int
) {
    fun getCantidadOperaciones() = getLongitudReal(this.movimientos) + getLongitudReal(this.golpes)
    fun getMovimientos() = getLongitudReal(this.movimientos)
    fun getGolpes() = getLongitudReal(this.golpes)

    fun quitarEnergia(quitaEnergia: Int) {
        this.energia -= quitaEnergia
    }

     fun validarSiHaPerdido(contrincante: Jugador): Boolean {
         if (this.energia <= 0) {
             println("${contrincante.nombre} gana la pelea y aun le quedan ${contrincante.energia} de energía")
             return true
         }
         return false
     }
    
    private fun getLongitudReal(operaciones: List<String>): Int {
        var contador = 0
        for (op in operaciones) if (op != "") contador++
        return contador
    }
}

data class Jugadores(
    val player1: Jugador,
    val player2: Jugador
)

data class Golpe(
    val combinacion: String,
    val quitaEnergia: Int,
    val descripcion: String
)

data class Ataque(
    val esSatisfactorio: Boolean,
    val golpe: Golpe? = null
)

object GolpesDescripcion{
    const val remuyuken = "Remuyuken"
    const val taladoken = "Taladoken"
    const val puno = "un Puño"
    const val patada = "una Patada"
}

val golpesEspecialesPlayer1 = listOf(
    Golpe("DSDP", 3, GolpesDescripcion.taladoken),
    Golpe("SDK", 2, GolpesDescripcion.remuyuken),
)

val golpesEspecialesPlayer2 = listOf(
    Golpe("SAK", 3, GolpesDescripcion.remuyuken),
    Golpe("ASAP", 2, GolpesDescripcion.taladoken),
)

val golpes = listOf(
    Golpe("P", 1, GolpesDescripcion.puno),
    Golpe("K", 1, GolpesDescripcion.patada)
)