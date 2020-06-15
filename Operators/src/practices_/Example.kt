package practices_

import java.util.*

fun main(args: Array<String>){
    //practices1.checkIsNightOrMorning(args[0].toInt())
    //practices1.dayOfWeek()
    /*for (i in 0..10) {
        var fortune=practices1.getFortuneCookie(practices1.getBirthday())
        println("Your fortune is: $fortune")
        if (fortune.contains("Take it easy"))break;
    }*/
    /*repeat(10){
        var fortune=practices1.getFortuneCookie(practices1.getBirthday())
        println("Your fortune is: $fortune")
        if (fortune.contains("Take it easy")) break;
    }*/
    /*var fortune=""
    while (fortune != "Take it easy and enjoy life!"){
        fortune=practices1.getFortuneCookie()
        println("Your fortune is: $fortune")
    }*/
    eagerLazyFilterExample()
}

fun eagerLazyFilterExample(){
    val list= listOf("prueba1","prueba2","Hola")
    val eager=list.filter { it[0] == 'p'}
    println(eager)
    //Apply filter lazily
    val lazy=list.asSequence().filter { it[0]=='p' }
    println(lazy)
    //Ahora se ejecutara el filtro. Antes solo se obtiene la sequencia para el filtro
    //TODO mirarlo despues
    println(lazy.toList())

    //apply map lazily
    val lazyMap=list.asSequence().map { println("map: $it")
    it}
    println(lazyMap)
    println("First: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")


}

fun getFortuneCookie(birthday: Int): String{
    val fortunes= listOf("You will have a great day","Things will go well for you today","Enjoy a wonderful day of success","Be humble and all will turn out well","Today is a good day for exercising restraint"
    ,"Take it easy and enjoy life!","Treasure your friends because they are your greatest fortune")
    //return fortunes[birthday.rem(fortunes.size)]
    return when(birthday){
        28,31 -> fortunes[5]
        in 1..7 -> fortunes[1]
        else -> fortunes[birthday.rem(fortunes.size)]

    }
}

fun getBirthday(): Int{
    print("Enter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}

fun checkIsNightOrMorning(hour: Int){
    println("${if (hour <12) "Good morning" else "Good night"},Kotlin")
}

fun dayOfWeek(){
    println("What day is it today?")
    when(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)){
        Calendar.SUNDAY-> print("Sunday")
        Calendar.SATURDAY-> print("SATURDAY")
        Calendar.FRIDAY-> print("FRIDAY")
        Calendar.THURSDAY-> print("THURSDAY")
        Calendar.WEDNESDAY-> print("WEDNESDAY")
        Calendar.TUESDAY-> print("TUESDAY")
        Calendar.MONDAY-> print("Monday")
    }
}

fun randomDay() : String{
    val week= listOf("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday")
    return week[Random().nextInt(7)]
}