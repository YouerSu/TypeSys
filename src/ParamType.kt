open class ParamType(typeName: String, val paramAmount: Int) : Type(typeName) {
    class InstanceType(typeName: String, val instanceName: String, val paramTypes: Array<Type>) : Type(typeName){
        override fun proper(type: Type): Boolean {
            when (type) {
                is InstanceType -> {
                    return type.typeName == typeName
                }
                is ParamType -> {
                    return type.typeName == instanceName
                }
                else -> {
                    return type.typeName == typeName
                }
            }
        }
    }

    fun createInstance(paramTypes: Array<Type>): InstanceType {
        if (paramTypes.size == paramAmount){
            return InstanceType(instanceTypeName(paramTypes),typeName,paramTypes)
        }else{
            error("Wrong Instance")
        }
    }

    companion object{
        fun instanceTypeName(params: Array<Type>) : String{
            var name : String = ""
            params.forEach { name.plus("${it.toString()} ") }
            return name.dropLast(1)
        }
    }
}