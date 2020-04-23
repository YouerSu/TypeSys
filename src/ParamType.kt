open class ParamType(override val typeName: String, val paramAmount: Int) : Type(typeName) {
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

    fun createInstance(typeName: String, instanceName: String, paramTypes: Array<Type>): InstanceType {
        if (paramTypes.size == paramAmount){
            return InstanceType(typeName,instanceName,paramTypes)
        }else{
            error("Wrong Instance")
        }
    }
}
