package practices_

/**
 * Immutable collections are particularly useful in a threaded environment
 * where you might be in trouble if multiple threads touch the same collection
 *
 */

fun main() {
    val allBooks= setOf<String>("Hamlet","First Folio","King Lear","The Tempest")
    val library= mapOf("William Shakespeare" to allBooks)
    library.any { it.value.contains("Hamlet") }

    val moreBooks= mutableMapOf("Born a crime" to "Trevor Noah")
    moreBooks.getOrPut("jokes",{"MIO"})
    print(moreBooks)

}
