class Unknown(val identity: String) : Type(identity){
var possibleTypeName: String? = null
    override fun `is`(type: Type): Boolean {
        if (type is Unknown&&type.possibleTypeName == null){
            return true
        }else{
            return checkType(type)
        }
    }

    private fun checkType(type: Type): Boolean {
        val possibleTypeName = possibleTypeName
        if (possibleTypeName != null){
            val possibleType = getType(possibleTypeName)
            if (type.`is`(possibleType)){
                this.possibleTypeName = type.typeName
                return true
            }else{
                return false
            }
        }else{
            addPossibleType(type.typeName)
            return true
        }
    }

    private fun addPossibleType(typeName: String){
        possibleTypeName = typeName
    }

    override fun toString(): String {
        possibleTypeName?.let { return it }
        return identity
    }
}