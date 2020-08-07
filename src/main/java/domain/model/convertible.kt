package domain.model

interface convertible {
    fun convertirUnidadesA(convertible: convertible): Double?
    fun equivalenciaPara(convertible: convertible): Double?
    fun cambiarUnidades(unidades : Double)
}