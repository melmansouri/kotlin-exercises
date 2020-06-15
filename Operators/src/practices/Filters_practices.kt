package practices
/**
 * By default filter analyst is eager
 * (that means every time you call filter, It creates a new list with the elements that pass
 * through the filter)
 * If you want lazy behavior in kotlin you can use sequences.
 * A sequence is a collection that can only look at one item at a time, stating at the beginning and going to the end
 * val filtered=decorationsList.asSequence().filter{it[0]=='p'}
 * filtered won't hold a new list. it'll hold a sequence of all of the list elements
 * and knowledge of the filter to apply to its elements. Whenever you access elements of the sequence
 * the filter is applied and the results are returned to you.
 * If we want to turn our sequence back into the list-filtered.toList() (At that point the filter will be run)
 *
 */
fun main(args: Array<String>){
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )
    println(spices.filter { it.contains("curry") }.sortedBy { it.length })
    println("Eager Filter: ")
    println(spices.filter { it.startsWith('c') && it.endsWith('e') })
    println("Lazy Filter: ")
    val filter= spices.asSequence().filter { it.startsWith('c') && it.endsWith('e') }
    println(filter.toList())
    println(spices.subList(0,3).filter { it.startsWith('c') })
    println(spices.take(3).filter { it.startsWith('c') })
}