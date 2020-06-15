package practices_

import java.util.*


/**
 * Allows you to add functions to an existing class without having
 * access to its source code.
 * ex. You could declare them in extensions.kt as part of your package
 * Under the hood, extensions do not actually modify the classes they extend.
 * By defining an extension, you do not insert new members into th class.
 * You merely make a new function callable with the dot-notation on variables
 * of this type.
 * Ex. fun String.hasSpace():Boolean{}
 * Inside the extension function, this is bound to the instance it's called on
 * We can define extension functions for helpers.
 * Extension functions are defined outside of the class they extend, so
 * they don't get access to privite members.
 * Extension functions are helpers functions that rely only on the public API
 * Extension functions are resolved statically, that is at compile time, and
 * the compiler, it just looks at the type of the variable.
 *
 * We can define extension properties too, just like extension function
 * Ex. val String.isGreen: Boolean
 *          get()=color(public)=="green"
 *
 * See with nullable '?'
 */
class BookExtension(var title:String){
    var pages= 100
}

fun BookExtension.calculateWeight():Double=pages.times(1.5)
fun BookExtension.tornPages(tornPages:Int){
    if (pages>=tornPages) pages-=tornPages else pages =0
}

class Puppy{
    fun playWithBook(book: BookExtension,tornPages: Int){
        book.tornPages(tornPages)
    }
}

fun main() {
    val puppy =Puppy()
    val book=BookExtension("The Quijote")
    println("${book.title} has ${book.pages} pages")
    while (book.pages>0){
        puppy.playWithBook(book, Random().nextInt(10))
        println("${book.pages} left in ${book.title}")
    }
    println("Now ${book.title} has ${book.pages} pages, after dog plays with the book")
}