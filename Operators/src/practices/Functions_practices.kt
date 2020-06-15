package practices

import java.util.*

fun main(args: Array<String>){
    while(true){
        val result=getFortuneCookie(getBirthday())
        println("Your fortune is: $result")
        if (result.contains("Take it easy")) break
    }
    /*greetings(args)
    dayOfWeek()*/
}

fun dayOfWeek(){
    println("What day is it today?")
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println( when (day) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> "Time has stopped"
    })
}

fun greetings(args: Array<String>){
    println(if (args[0].toInt()<12) "Good morning, Kotlin" else  "Good night, Kotlin")
}

fun getFortuneCookie(birthday: Int): String{
    val fortunes= listOf("You will have a great day!"
    ,"Things will go well for you today."
    ,"Enjoy a wonderful day of success."
    ,"Be humble and all will turn out well."
    ,"Today is a good day for exercising restraint."
    ,"Take it easy and enjoy life!"
    ,"Treasure your friends because they are your greatest fortune.")
    val fortune= when(birthday){
        28,31->4
        in 1..7->2
        else->birthday.rem(fortunes.size)
    }
    return fortunes[fortune]
}

fun getBirthday():Int{
    print("Enter your birthday: ")
    return readLine()?.toIntOrNull() ?:1
}
