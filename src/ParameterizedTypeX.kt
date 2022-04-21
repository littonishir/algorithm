import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


fun main() {
//    getParentClassParameterize()
    getMethodParameterize()
}

//java.util.List<java.util.Map<java.lang.String, java.lang.Boolean>>
//java.util.Map<java.lang.String, java.lang.Boolean>
//java.util.Map<java.util.HashSet<java.lang.String>, ? extends java.util.List<java.lang.Integer>>
//java.util.HashSet<java.lang.String>
//java.util.List<java.lang.String>
//(Ljava/util/Map<Ljava/util/HashSet<Ljava/lang/String;>;+Ljava/util/List<Ljava/lang/Integer;>;>;Ljava/util/List<Ljava/lang/String;>;)Ljava/util/List<Ljava/util/Map<Ljava/lang/String;Ljava/lang/Boolean;>;>;
class ParameterizedTypeX {
    fun testMethod(items: Map<HashSet<String>, List<Int>>, param: List<String>): List<Map<String, Boolean>> {
        println("testMethod")
        return emptyList()
    }
}

/**
 * 获取方法参数泛型实参、返回值泛型实参
 */
fun getMethodParameterize() {
    val method = ParameterizedTypeX::class.java.getDeclaredMethod("testMethod", Map::class.java, List::class.java)
    val genericReturnType = method.genericReturnType
    val genericParameterTypes = method.genericParameterTypes
    getParameterizedTypeX(genericReturnType)
    genericParameterTypes.forEach {
        getParameterizedTypeX(it)
    }
    val field = method.javaClass.getDeclaredField("signature")
    field.isAccessible = true
//    field.set(method,"The signature has been tampered with by me")
    println(field.get(method))
}

/**
 * 获取Class父类泛型实参
 */
fun getParentClassParameterize() {
    val catType = Cat::class.java.genericSuperclass
    val lionType = Lion::class.java.genericSuperclass
    getParameterizedTypeX(catType)
    getParameterizedTypeX(lionType)
}
//$Animal<java.lang.Integer>
//$Animal<java.util.List<? extends java.lang.String>>
//$java.util.List<? extends java.lang.String>

/**
 * 获取泛型实参
 * Java泛型在编译阶段就已经被处理成普通的类和方法，所以JVM并不知道泛型的存在。
 * 这？我们如何获取泛型实参呢！
 * 在字节码中的signature，保存着类/方法的泛型实参
 * 注意在混淆后我们通过反射也是拿不到泛型实参的，所以混淆时记的keep signature。
 */
fun getParameterizedTypeX(type: Type) {
    if (type is ParameterizedType) {
        println(type)
        type.actualTypeArguments.forEach {
            getParameterizedTypeX(it)
        }
    }
}

// ================Animal.class =================
// class version 50.0 (50)
// access flags 0x21
// signature <T:Ljava/lang/Object;>Ljava/lang/Object;
// declaration: Animal<T>
open class Animal<T>

// ================Cat.class =================
// class version 50.0 (50)
// access flags 0x31
// signature LAnimal<Ljava/lang/Integer;>;
// declaration: Cat extends Animal<java.lang.Integer>
class Cat : Animal<Int>()

// ================Lion.class =================
// class version 50.0 (50)
// access flags 0x31
// signature LAnimal<Ljava/util/List<+Ljava/lang/String;>;>;
// declaration: Lion extends Animal<java.util.List<? extends java.lang.String>>
class Lion : Animal<List<String>>()