package practices

fun main(args: Array<String>){
    print(whatShouldIDoToday(readLine()!!))
}

fun whatShouldIDoToday(mood: String, weather:String="sunny",temperature:Int=24):String {
    return when{
        mood=="happy"&& weather=="sunny"->"go for a walk"
        mood == "sad" && weather == "rainy" && temperature == 0 -> "stay in bed"
        temperature > 35 -> "go swimming"
        else->"Stay home and read."
    }
}

//See 15. Quiz Practice Time

