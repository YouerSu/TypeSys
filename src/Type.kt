open class Type(val typeName: String) {
    open fun proper(type: Type) = type.typeName == this.typeName


    companion object{
        private val types = HashMap<String,Type>()
        fun getType(typeName: String): Type {
            val type = types[typeName]
            if (type == null){
                error("Couldn't Find Type:$typeName")
            }else{
                return type
            }
        }

        fun addType(type: Type){
            if (types[type.typeName] != null){
                types[type.typeName] = type
            }else{
                error("Type ${type.typeName} has existed")
            }
        }
    }
}