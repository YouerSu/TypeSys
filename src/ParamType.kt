open class ParamType(override val typeName: String, val paramAmount: Int) : Type(typeName) {
    class InstanceType(typeName: String, paramTypes: Array<Type>) : Type(typeName){}

    fun createInstance(typeName: String,paramTypes: Array<Type>): InstanceType {
        if (paramTypes.size == paramAmount){
            return InstanceType(typeName,paramTypes)
        }else{
            error("Wrong Instance")
        }
    }
}
