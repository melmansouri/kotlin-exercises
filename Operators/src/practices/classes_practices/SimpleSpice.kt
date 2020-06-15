package practices.classes_practices

fun main() {
    println(SimpleSpice().toString())
    val spices = listOf(SimpleSpice(),
        SimpleSpice("pepper","spicy"),
        SimpleSpice("cayenne"),
        SimpleSpice("ginger"),
        SimpleSpice("red curry","spicy"),
        SimpleSpice("green curry","spicy"),
        SimpleSpice("red pepper","spicy x10")
        , makeSalt())

    val spicesLessSpicy=spices.filter { it.heat<10 }
    val spicesSpicies=spices.filter { it.heat>5 }

}

class SimpleSpice(var name:String="curry",var spiciness:String="mild"){
    val heat:Int
    get() = when(spiciness) {
        "low" ->1
        "mild"-> 5
        "spicy"->10
        "spicy x10"->100
        else -> 0
    }
    init {
        println("$name, $spiciness, $heat")
    }
    override fun toString(): String = "${name}, $heat"
}
fun makeSalt()=SimpleSpice("salt","low")

