package practices

import kotlin.random.Random

fun main() {
    testLamda()
    gamplay(rollDice2(12))
}

/**
 * Lambda are functions without name.
 * {print("lambda")}()
 */
val testLamda={ println("lambda") }
val testLamdaSum={x:Int,y:Int-> println("${x}+${y} = ${x+y}") }
//testLamdaMinus is any function that takes 2 int and returns the result of the operation
//With this we don't need to specify the type of the lambda argument
//Function type notation is more readable, which reduces errors, clearly showing the what type is passed in and what type is returned.
//Lambda function type notation
val testLamdaMinus: (Int,Int)->Int={x,y-> x-y }
/**
 * The real power of lambda happens when we make higher-order funcitons
 * Higher-order functions is just any function that takes a function as the argument
 * Kotlin prefers function arguments to be the last parameter
 */
val sum: (Int)->Int={x-> x+x }
fun sumFun(x: Int)=x+x
fun printResult(x:Int, sumOperation:(Int)->Int):String{
    return "${sumOperation(x)}"
}

fun testHighOrderFunctions(){
    printResult(2, ::sumFun)
    printResult(2,sum)
    //When you combine higher-order functions with lambdas. Kotlin has a special syntax
    //It's called the last parameter called syntax
    printResult(2){x->x*2}
}

val rollDice={side:Int->
    if (side==0) 0
    else Random.nextInt(side)+1}
val rollDice2:(Int)->Int={side->
    if (side==0) 0
    else Random.nextInt(side)+1}

fun gamplay(rollDice: Int){
println(rollDice)
}
