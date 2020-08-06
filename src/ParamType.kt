open class ParamType(typeName: String, vararg val types: Type) : Type(typeName) {
    private val instanceName: String
    init {
        var temp = ""
        types.forEach { temp = temp.plus(it.toString())+" " }
        temp.dropLast(1)
        instanceName = "($typeName $temp)"
    }

    override fun `is`(type: Type): Boolean {
        when (type) {
            is ParamType -> {
                if (types.size == type.types.size){
                    (0..types.lastIndex).forEach { if (types[it].`is`(type.types[it]).not()) return false}
                    return true
                }else{
                    return false
                }
            }
            else -> {
                return false
            }
        }
    }

    override fun toString(): String = instanceName

}