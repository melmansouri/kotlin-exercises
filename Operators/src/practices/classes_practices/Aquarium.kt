package practices.classes_practices

fun main(){
    val aquarium= buildAquarium()
    println("Volume: ${aquarium.volume}")
}
private fun buildAquarium()=Aquarium()
/**
 * Package visibility
 *  Internal means to be visible anywhere in the same module
 *  A module is a set of kotlin files compiled together.
 *  With this if we compile the library, it wouldn't be exported as a function
 * Class Visibility
 *  protected means the same as private, but members are also visible to subclasses
 *  Internal - It works just like internal at the file level
 */

//This is good kotlin
internal class Aquarium(var width:Int=0, var height:Int=40, var length:Int=100) {
//This is bad kotlin
/*internal class Aquarium(width:Int=0,  height:Int=40, length:Int=100) {
    var width:Int=width
    var height:Int=height
    var length:Int=length*/
    var volume
        get() = width*height*length / 1_000
        set(value)  {height=(value*1000) / (width*length)}
    /**
     * The properties get initialized in the order in with they are defined
     */
    var water=volume*0.9

    constructor(numberOfFish:Int): this(){
        val water:Int=numberOfFish*2000//cm3
        val tank=water+water*0.1
        height=(tank/(length*width)).toInt()
    }
}

class fish(val friendly :Boolean=true,volumeNeeded:Int){
    val size:Int

    /**
     * You can use init blocks like a contructors body in other languages
     * You can have more than one in init block
     * They always run before any secondary constructors
     * They can be almost anywhere in your class
     * They're executed in order form the top of the class to the bottom
     *
     */
    init {
        println("first ini block")
    }

    /**
     * Good kotlin only define one contructor with default
     * parameters for optional values
     * If you would make a secondary contructor, consider making a helper
     * method instead like this one,
     * fun makeDefaultfish()=Fish(true,50)
     * This keeps your classes simple while providing a clean API
     */
    constructor():this(true,9){
        println("running secondary constructor")
    }
    init {
        size = if (friendly){
            volumeNeeded
        }else{
            volumeNeeded*2
        }
    }
    init{
        println("last init")
    }
}