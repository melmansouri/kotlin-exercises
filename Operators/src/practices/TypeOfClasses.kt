package practices

//Singleton
object MoyDickWhale{
    val author="Herman Melville"
}

/**
 * Enums are like the MobyDickWhale object
 * Kotlin will make exactly one red, green and blue
 * There's no way to create more than one color object and there's not any way to define more colors,
 * other than where the enum is declared
 */
enum class Color(val rgb:Int){
    RED(0xFF0000),
    GREE(0x00FF00),
    BLUE(0x0000FF)
}

/**
 * A sealed class is a class that can be subclassed but only inside the file with it's declared
 * If you try to subclass it in a different file, you'll get an error
 * Because the class and the subclasses are in the same file, kotlin will be able to
 * know all subclasses statically, that is at compile time.
 * The compiler can see all of the classes and subclasses and it knows these are
 * all of them. So, the compiler can do extra checks for you
 * This makes sealed classes a safe way to represent a fixed number of types.
 * They're great for returning success or err from a network API, for example
 */
sealed class Seal

class SeaLion:Seal()
class Walrus:Seal()

/**
 * If i don't match all of the types of seal, kotlin
 * will give me a compile error
 */
fun matchSeal(seal: Seal):String{
    return when(seal){
        is SeaLion->"Sea Lion"
        is Walrus->"Walrus"
    }
}