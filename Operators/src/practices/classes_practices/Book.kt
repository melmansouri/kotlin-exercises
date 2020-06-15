package practices.classes_practices

open class Book(var title:String, var author:String) {
    private var currentPage:Int=1
    open fun readPage() {currentPage++}
}

class eBook():Book("Born a crime","Trevor Noah"){
    private var wordsRead=0
    override fun readPage(){ wordsRead += 250}

}