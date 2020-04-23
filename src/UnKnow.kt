final class UnKnow(val context: String) : Type(context){
var possibleType: String? = null
    override fun proper(type: Type): Boolean {
        if (type is UnKnow){
            return true
        }else if (possibleType == null){
            addPossibleType(type.typeName)
            return true
        }else{
            return checkType(type)
        }
    }

    private fun checkType(type: Type): Boolean {
        val possibleType = possibleType
        if (possibleType != null){
            return type.proper(getType(possibleType))
        }else{
            return true
        }
    }

    fun addPossibleType(typeName: String){
        possibleType = typeName
    }

}