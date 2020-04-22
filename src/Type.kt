private val types = HashMap<String,Type>()

fun addType(type: Type){
    if (types[type.typeName] != null){
        types[type.typeName] = type
    }else{
        error("Type ${type.typeName} has existed")
    }
}

open class Type(open val typeName: String) {

}