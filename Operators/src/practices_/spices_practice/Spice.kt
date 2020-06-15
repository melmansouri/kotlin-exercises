package practices_.spices_practice

class Spice(private val name:String, private val spiciness:String = "mild"){

    init {
        println("$name - Spiciness: $spiciness - Heat: $heat")
    }
    val heat: Int
        get() =when(spiciness){
            "mild" -> 1
            "medium" -> 3
            "spicy" -> 5
            "very spicy" -> 7
            "extremely spicy" -> 10
            else -> 0
        }
}
//Es recomendable usar estos helpers en lugar de crear mas de un constructor
//Lo mejor siempre es utilizar un constructor primario y los init
//En caso de usar contructor segundario, este simpre debe de hacer uso tambien del primerio con :this(arguments)
//Los init se ejecutan de arriba a abajo y siempre antes del segundo contructor
fun makeSalt()= Spice("Salt")
fun main() {
    val spice= Spice("dd")
    //println("${spice.name}-${spice.heat}")
    var listSpices = listOf(
        Spice("chilli", "spicy"),
        Spice("curry")
    )
    val listMostSipcy=listSpices.filter { it.heat<5 }
    println(listMostSipcy)
    makeSalt()
}