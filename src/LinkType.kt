class LinkType(val types: Array<Type>) : Type(toString()) {

    fun add(type: Type): LinkType{
        return LinkType(types.plus(type))
    }

    fun remove(type: Type,where: Int): LinkType{
        if (types[where] == type) {
            return LinkType(types.dropLast(types.size - where).plus(types.drop(where + 1)).toTypedArray())
        }else{
            error("Wrong Type")
        }
    }

    override fun toString(): String {
        var name = ""
        types.forEach { name = name.plus("${it.toString()}->") }
        return name.dropLast(2)
    }
}