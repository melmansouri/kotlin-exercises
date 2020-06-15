package practices_

/**
 *You can use pairs to return more than one values from a function
 * Destructuring. To take apart an object and assign it to multiple variables
 * ex. val (tool,use)=object
 */

fun main(){
    val book=Book("Born a crime","Trevor Noah",2016)
    val (title,author)=book.infoBookPair()
    val (titleTriple,authorTriple,year)=book.infoBookTriple()
    println("Here is your book $title written by $author in $year")
}

class Book(var title: String,var author:String,var year:Int){
    fun infoBookPair(): Pair<String, String> {
        return title to author
    }

    fun infoBookTriple(): Triple<String, String,Int> {
        return Triple(title,author,year)
    }
}