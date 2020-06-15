package practices_

/**
 * Const val, the value is always determined at compile time
 * val, the value that is assigned can be determined during program execution
 * So for val we can assign the return value from a function as its value because we can set it during execution
 * With const val, we cannot do that because is set at compile time.
 * Const val only works at the top level and in classes declared as object
 */
object Constants{
    const val CONSTANTS2= "object constant"
}
/**
 * To define constants inside a class, you have to wrap them into a companion
 * object.
 * Companion object are initialized from the static constructor of the
 * containing class, that is, they are created when the object is created.
 * Plain objects are initialized lazily on the first access to that object, that
 * is when they are first used
 */
class MyClas{
    companion object{
        const val CONSTANTS= "companion object constant"
    }
}

fun main() {

}
//Top-level class
const val MAX_NUM_BOOKS_BORROW=3
class BookClass(var title:String){
    companion object{
        const val BASE_URL:String="www.google.com/"
    }

    fun canBorrow(numberBooksBorrowd:Int)=numberBooksBorrowd<MAX_NUM_BOOKS_BORROW

    fun printUrl()=ConstantsBook.BASE_URL.plus(title).plus(".html")
}

object ConstantsBook{
    const val BASE_URL:String="www.google.com/"
}