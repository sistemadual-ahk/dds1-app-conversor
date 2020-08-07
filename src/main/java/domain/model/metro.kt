package domain.model

object metro : convertible{
    var unidades = 1.0
    var equivalencias = HashMap<convertible, Double>()

    init {
        this.equivalencias.put(metro, 1.0)
        this.equivalencias.put(centimetro, 100.0)
        this.equivalencias.put(milimetro, 1000.0)
        this.equivalencias.put(kilometro, 0.001)
    }

    override fun convertirUnidadesA(convertible: convertible): Double? {
        return this.unidades * this.equivalenciaPara(convertible)!!
    }

    override fun equivalenciaPara(convertible: convertible): Double? {
        return this.equivalencias[convertible]
    }

    override fun cambiarUnidades(unidades: Double) {
        this.unidades = unidades
    }

    override fun toString(): String {
        return "Metro"
    }
}