package practices_.books_practices

open class Book(val title:String,val author:String){

    private var currentPage: Int=0
    open fun readPage(){
        currentPage++
    }
}

class eBook(title: String,author: String,format: String="text") :
    Book(title,author){
    private val wordCount:Int =0
    override fun readPage() {
        wordCount.plus(250)
    }
}
fun main(){

}