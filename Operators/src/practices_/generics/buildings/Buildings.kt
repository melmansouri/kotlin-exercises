package practices_.generics.buildings

open class BaseBuildingMaterial(){
    open val numberNeeded:Int=1
}

class Wood: BaseBuildingMaterial(){
    override val numberNeeded: Int=4
}

class Brick: BaseBuildingMaterial(){
    override val numberNeeded: Int=8
}

//Out generic. With out generic can't use var as constructor parameter
//See why later
class Building<out T:BaseBuildingMaterial>(val buildingMaterial:T){
    val baseMaterialsNeeded=100
    val actualMaterialNeeded
        get() =buildingMaterial.numberNeeded*baseMaterialsNeeded

    fun build() = println("$actualMaterialNeeded ${buildingMaterial::class.simpleName} required ")
}

fun main() {
    val wood=Wood()
    val building=Building(wood)
    exampleOut(building)
    building.build()
}
fun exampleOut(building: Building<BaseBuildingMaterial>){
}