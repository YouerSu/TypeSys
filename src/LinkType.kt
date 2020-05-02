class LinkType(typeName: String, val typeLink: Array<Type>) : Type(typeName) {
    fun default(type: Type): Type{
        if (type.proper(this)){
            val types = (0 until typeLink.lastIndex).map { typeLink[it] }
            return LinkType(instanceTypeName(types.toTypedArray()),types.toTypedArray())
        }else{
            error("Wrong Type")
        }
    }

    companion object{
        fun instanceTypeName(params: Array<Type>) : String{
            var name : String = ""
            params.forEach { name.plus("${it.toString()}->") }
            return name.dropLast(2)
        }
    }
}