package practices_

fun main() {
    print(whatShouldIDoToday(readLine()!!))
}

fun whatShouldIDoToday(mood:String,weather:String="Sunny",temperature:Int=24/*Celsius*/): String{
    return when{
        goForAWalk(mood, weather) -> "go for a walk"
        stayInBed(mood, weather, temperature) ->"stay in bed"
        checkTemperatureToSwim(temperature) ->"go swimmming"
        else -> "Stay home and read."
    }
}

fun checkTemperatureToSwim(temperature: Int)=temperature>35
fun stayInBed(mood: String,weather: String,temperature: Int)=mood=="Sad" && weather=="rainy"&&temperature==0
fun goForAWalk(mood: String,weather: String)=mood == "happy" && weather == "Sunny"