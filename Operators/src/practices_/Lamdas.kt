package practices_

import kotlin.random.Random

fun main() {
    example()
    println(rollDice(0))
}

//Lambda using function type notation
val rollDice: (Int)->Int={ sidesDiceRoll-> if(sidesDiceRoll==0){0}else{ Random.nextInt(1,sidesDiceRoll+1)}}
//Normal lambda
val rollDice2={sidesDiceRoll:Int -> Random.nextInt(1,sidesDiceRoll+1)}

fun example(){
//Lamdas are functions without names
    example1()
    println("Lambda: ${example2(2, sumOperation)}")
    //We use double colon to parse it to lambda
    println("Name Function: ${example2(2, ::sumOperation)}")
    println(example2(2) { x -> x + 13434 })
}

fun example1(){
    var dirty=20
    //val waterFilter={dirty: Int->dirty/2}
    //CAn be any function that takes an int and returns an int
    val waterFilter: (Int) -> Int={dirty->dirty/2}
    println(waterFilter(dirty))
}

//The real power of lambda happens when we make the higher-order functions
//Is just any function that takes a function as the argument
//Kotlin prefers function argument to be the last parameters
fun example2(x: Int, operation: (Int)->Int): Int{
    return operation(x)
}
//Lambda
val sumOperation:(Int)->Int={x->x+x}
//Name function. La de toda la vida
fun sumOperation(x: Int):Int{
    return x+x;
}
