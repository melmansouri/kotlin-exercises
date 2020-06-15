package practices.classes_practices

fun main() {

}
/**
 * Interfaces and abstract classes can contain implementations of methods
 * On Interfaces we call them default implementations
 * Use an interface if you have a lot of methods and one or 2 default implementations
 * like this
 */

interface AquariumAction{
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim(){
        println("Swim")
    }
}

/**
 * Use an abstract class anytime you can't complete a class
 */

interface fishAction{
    fun eat()
}
abstract class AquariumFish:fishAction{
    // color is abstract because there isn't really a good default color for a fish
    //But really, kotlin provides us a better tool for this than abstract classes
    // Interface delegation
    abstract val color:String
    override fun eat() {
        print("yum")
    }
}
/***
 * Interface delegation. Let's you add features to a class via composition
 * Composition is when you use an instance of another class as opposed to inheriting from it
 */
interface fishColor{
    val color:String
}
//We can remove inheritance form aquarium fish, because we get all the functionality from the interfaces
//class Plecostomus: AquariumFish(){
class Plecostomus:fishColor,fishAction{
    override fun eat() {
        println("eat algae")
    }
    override val color: String
        get() = "gold"
}
//--------------------------------------------------------------------------------
/**
 * fishColor by GoldColor means implement the interface fishColor
 * by deferring all calls to the object, GoldColor
 * So every time we call the color property on this class, it wll
 * actually call the colo property on GoldColor
 */
//class PlecostomusInterfacesDelegation:fishColor by GoldColor,fishAction{
/*class PlecostomusInterfacesDelegation(fishcolor: fishColor=GoldColor):fishColor by fishcolor,fishAction{
    override fun eat() {
        println("eat algae")
    }
}*/
/**
 * We delegate the action to print food to PrintFishAction
 */
class PlecostomusInterfacesDelegation(fishcolor: fishColor=GoldColor):fishColor by fishcolor,
    fishAction by PrintingFishAction("A lot of algae")
/***
 * Now let's use interface delegation to provide a color implementation.
 * To do that, we need an object that knows how to provide a fish color
 */
object GoldColor:fishColor{
    override val color: String
        get() = "Gold"}
object RedColor:fishColor{
    override val color: String
        get() = "Red"}


/**
 * We can't make printingFishAction an Object.
 * We want a different instance for each food tha we pass in
 */
class PrintingFishAction(val food: String):fishAction{
    override fun eat() {
        println(food)
    }

}

fun delegate(){
    val pleco=PlecostomusInterfacesDelegation(RedColor)
    println("Fish has colo ${pleco.color}")
    pleco.eat()
}

/**
 * Interface delegation is powerful
 * You should generally consider how to use it whenever you might use an
 * abstract class in another language. It let's you use composition to plug-in
 * behaviors, instead of requiring a lot of sub-classes, each specialized in
 * a different way
 */


