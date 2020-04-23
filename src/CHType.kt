import java.util.*

class CHType(typeName: String, val typeLink: LinkedList<Type>) : Type(typeName) {
    fun link(type: CHType){
        if (typeLink.last.proper(type.typeLink.first)){
            typeLink.removeLast()
            typeLink.addAll(type.typeLink)
        }else{
            error("Can't be linked")
        }
    }
}