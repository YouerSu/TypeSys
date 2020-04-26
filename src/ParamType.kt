open class ParamType(typeName: String, val paramAmount: Int) : Type(typeName) {
    class InstanceType(typeName: String, val instanceName: String, paramTypes: Array<Type>) : Type(typeName){
        override fun proper(type: Type): Boolean {
            if (type is InstanceType){
                return type.typeName == typeName
            }else if (type is ParamType){
                return type.typeName == instanceName
            }else{
                return typeName == type.typeName
            }
        }
    }

    fun createInstance(paramTypes: Array<Type>): InstanceType {
        fun instanceTypeName(params: Array<Type>) : String{
            var name : String = ""
            paramTypes.forEach { name.plus("${it.typeName} ") }
            return name.dropLast(1)
        }
        if (paramTypes.size == paramAmount){
            return InstanceType(instanceTypeName(paramTypes),typeName,paramTypes)
        }else{
            error("Wrong Instance")
        }
    }
}
