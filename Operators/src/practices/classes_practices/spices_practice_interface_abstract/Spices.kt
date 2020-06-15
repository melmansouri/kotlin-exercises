package practices.classes_practices.spices_practice_interface_abstract

fun main() {
    val curry=Curry("curry","spicy")

    //Kotlin let's us use a process called decomposition
    //We can make 2 variables, one for each property and assign the object to it
    //val(name:String,spiceness:kotlin.String,heat: Int)=curry
    val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", "mild")),
        SpiceContainer(Curry("Red Curry", "medium")),
        SpiceContainer(Curry("Green Curry", "spicy")))
    for(element in spiceCabinet) println(element.label)
}
data class SpiceContainer(var spice :Spice,val label:String=spice.name)

//Making Spice a sealed class helps keep all the spices together in one file
abstract class Spice(var name:String="curry",var spiciness:String="mild",spiceColor: SpiceColor):SpiceColor by spiceColor{
    private val heat:Int
        get() = when(spiciness) {
            "low" ->1
            "mild"-> 5
            "spicy"->10
            "spicy x10"->100
            else -> 0
        }
    init {
        println("$name, $spiciness, $heat, $color")
    }

    abstract fun prepareSpice()
    override fun toString(): String = "${name}, $heat"
}

class Curry(name:String,spicinessCurry: String,colorSpice:SpiceColor=YellowSpiceColor):Spice(name,spiciness = spicinessCurry,spiceColor = colorSpice),Grinder{
    override fun prepareSpice() {
        println("prepare spice")
        grind()
    }

    override fun grind() {
        println("Grind $name into a powder")
    }
}

interface Grinder{
    fun grind()
}

interface SpiceColor{
    val color:Color
}

enum class Color(val rgb:Int){
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF),
    YELLOW(0xFFFF00);
}

object YellowSpiceColor:SpiceColor{
    override val color: Color=Color.YELLOW
    /*override val color: String
        get() = "yellow"*/
}