import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

fun main() {
    println("Ingresa los datos de la pelea: ")
    val scanner = Scanner(System.`in`)
    val jugadores = TalanaKombat().establecerOrdenJugadores(
        Gson().fromJson(scanner.nextLine(), object : TypeToken<Jugadores>() {}.type)
    )
    TalanaKombat().ejecutarJuego(jugadores.player1, jugadores.player2)

    scanner.close()
}

class TalanaKombat {

    fun establecerOrdenJugadores(jugadores: Jugadores): Jugadores {
        var primerJugador = jugadores.player1.copy(
            energia = 6, nombre = "Tonyn", golpesEspeciales = golpesEspecialesPlayer1
        )
        var segundoJugador = jugadores.player2.copy(
            energia = 6, nombre = "Arnaldor", golpesEspeciales = golpesEspecialesPlayer2
        )

        if (cambiarOrdenAtaque(primerJugador, segundoJugador)) {
            val aux = primerJugador
            primerJugador = segundoJugador
            segundoJugador = aux
        }

        return Jugadores(primerJugador, segundoJugador)
    }

    fun ejecutarJuego(primerJugador: Jugador, segundoJugador: Jugador) {
        for (index in segundoJugador.movimientos.indices) {
            segundoJugador.quitarEnergia(atacarContrincante(index, primerJugador))
            if (segundoJugador.validarSiHaPerdido(primerJugador)) break
            
            primerJugador.quitarEnergia(atacarContrincante(index, segundoJugador))
            if (primerJugador.validarSiHaPerdido(segundoJugador)) break
        }
    }

    private fun cambiarOrdenAtaque(primerJugador: Jugador, segundoJugador: Jugador): Boolean {
        if (primerJugador.getCantidadOperaciones() > segundoJugador.getCantidadOperaciones()) {
            return true
        } else if (primerJugador.getCantidadOperaciones() == segundoJugador.getCantidadOperaciones() &&
            primerJugador.getMovimientos() > segundoJugador.getMovimientos()) {
            return true
        } else if (primerJugador.getMovimientos() == segundoJugador.getMovimientos() &&
            primerJugador.getGolpes() > segundoJugador.getGolpes()) {
            return true
        }
        return false
    }
    
    private fun atacarContrincante(index: Int, jugador: Jugador): Int {
        var puntosEnergia = 0
        
        if (jugador.movimientos.size > index) {
            Thread.sleep(1500)
            val golpe = jugador.golpes[index]
            val movimiento = jugador.movimientos[index]
            val combinacion = movimiento + golpe

            val esGolpeEspecial = validarSiEsGolpeEspecial(jugador, combinacion)
            if (esGolpeEspecial.esSatisfactorio && esGolpeEspecial.golpe != null) {
                puntosEnergia = esGolpeEspecial.golpe.quitaEnergia
            } else {
                val esMovimientoYGolpeEspecial = validarSiEsMovimientoYGolpeEspecial(jugador, combinacion)
                if (esMovimientoYGolpeEspecial.esSatisfactorio && esMovimientoYGolpeEspecial.golpe != null) {
                    puntosEnergia = esMovimientoYGolpeEspecial.golpe.quitaEnergia
                } else {
                    val esGolpeNormal = validarSiEsGolpeNormal(jugador, golpe, movimiento)
                    if (esGolpeNormal.esSatisfactorio && esGolpeNormal.golpe != null) {
                        puntosEnergia = esGolpeNormal.golpe.quitaEnergia
                    }
                }
            }
        }
        return puntosEnergia
    }
    
    private fun validarSiEsGolpeEspecial(jugador: Jugador, combinacion: String): Ataque {
        val esGolpeEspecial = jugador.golpesEspeciales.find { combinacion == it.combinacion }
        if (esGolpeEspecial != null) {
            println("${jugador.nombre} conecta un ${esGolpeEspecial.descripcion}")
            return Ataque(true, esGolpeEspecial)
        }
        return Ataque(false)
    }

    private fun validarSiEsMovimientoYGolpeEspecial(jugador: Jugador, combinacion: String): Ataque {
        val esMovimientoYGolpeEspecial = jugador.golpesEspeciales.find { combinacion.contains(it.combinacion) }
        if (esMovimientoYGolpeEspecial != null) {
            println("${jugador.nombre} se mueve y usa un ${esMovimientoYGolpeEspecial.descripcion}")
            return Ataque(true, esMovimientoYGolpeEspecial)
        }
        return Ataque(false)
    }

    private fun validarSiEsGolpeNormal(
        jugador: Jugador, combinacion: String, movimiento: String
    ): Ataque {
        val esGolpeNormal = golpes.find { combinacion.contains(it.combinacion) }
        if (esGolpeNormal != null && movimiento != "") {
            println("${jugador.nombre} avanza y conecta ${esGolpeNormal.descripcion}")
            return Ataque(true, esGolpeNormal)
        } else if (movimiento != "") {
            println("${jugador.nombre} se mueve")
        } else if (esGolpeNormal != null) {
            println("${jugador.nombre} da ${esGolpeNormal.descripcion}")
            return Ataque(true, esGolpeNormal)
        }
        return Ataque(false)
    }
}

