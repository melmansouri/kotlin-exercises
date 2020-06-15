package practices_

fun main() {
    println(canAddFish(10.0, listOf(3, 3, 3)))
    println(canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false))
    println(canAddFish(9.0, listOf(1, 1, 3), 3))
    println(canAddFish(10.0, listOf(), 7, true))
}

fun canAddFish(gallon: Double,currentFish: List<Int>,fishSize: Int=2,hasDecorations: Boolean=true) :Boolean{
    /*var currentLengthFish=0
    for (i in currentFish){
        currentLengthFish+=i
    }
    return if (hasDecorations){
        fishSize.plus(currentLengthFish) < gallon.times(0.8)
    }else{
        fishSize.plus(currentLengthFish).toDouble() == gallon
    }*/
    return (gallon * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)

}