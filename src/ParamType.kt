open class ParamType(override val typeName: String, val paramAmount: Int) : Type(typeName) {
    class InstanceType(typeName: String, val instanceName: String, paramTypes: Array<Type>) : Type(typeName){}

    override fun check(type: Type): Boolean {
        if (type is InstanceType){
            return typeName == type.instanceName
        }else{
            return typeName == type.typeName
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
