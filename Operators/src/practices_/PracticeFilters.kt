package practices_

fun main() {
 val spices= listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")
    filterAndSortAllCurriesSpices(spices)
    filterSpicesStartCEndEWay1(spices)
    filterSpicesStartCEndEWay2(spices)
    filterFirstThreeElementsWhoStartWithC(spices)
}

fun filterAndSortAllCurriesSpices(spices: List<String>){
    println(spices.filter { it.contains("curry") }.sortedBy{ it.length })
}

fun filterSpicesStartCEndEWay1(spices: List<String>){
    println(spices.filter { it.startsWith('c') && it.endsWith('e')  })
}

fun filterSpicesStartCEndEWay2(spices: List<String>){
    //filter{it.startsWith('c')}.filter{it.endsWith('e')
    println(spices.asSequence().filter { it.matches(Regex("^c.*e$")) }.toList())
}

fun filterFirstThreeElementsWhoStartWithC(spices: List<String>){
    //spices.take(3)
    println(spices.subList(0,3).filter { it.startsWith("c") })
}
