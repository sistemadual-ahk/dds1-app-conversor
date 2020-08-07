package domain.model

object kilometro : convertible {
    var unidades = 1.0
    var equivalencias = HashMap<convertible, Double>()

    init {
        this.equivalencias.put(kilometro, 1.0)
        this.equivalencias.put(metro, 1000.0)
        this.equivalencias.put(centimetro, 100000.0)
        this.equivalencias.put(milimetro, 1000000.0)
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
        return "Kilómetro"
    }
}