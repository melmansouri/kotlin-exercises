package practices_.abstract_practices

abstract class Spice(private val name:String, private val spiciness:String = "mild",color: SpiceColor):
    SpiceColor by color{
    abstract fun prepareSpice()
}
class Curry(name: String,spiciness: String,color: SpiceColor = YellowSpiceColor):
    Spice(name,spiciness,color),
    Grinder {
    override fun prepareSpice() {
        grind()
    }

    override fun grind() {
    }
}

interface Grinder{
    abstract fun grind()
}

interface SpiceColor{
    val color:String
}

object YellowSpiceColor: SpiceColor {
    /*override val color: String
        get() = "Yellow"*/
    override val color="Yellow"
}