package lock

import com.sun.tools.javac.util.Context
import java.util.*

fun main(){
    var d = VolatileDemo()
    var d1 = VolatileDemo()

    var s = "hi"
    var s2 = "hi"
    println(d.x==d1.x)
    println(d.equals(d1))
//    val worker = WorkThread()
//    worker.start()
//    println("worker start ${Date().time}")
//    Thread.sleep(50)
//    while (true){
//        println("jian....")
//        if (worker.isFlag){
//            println("worker end ${Date().time}")
//            break
//        }
//    }

}

class VolatileDemo {

    var x = 2
    var y = 6
    val context = loadContext()
    @Volatile
    var inited = false


    private fun loadContext(): Context {
        return Context()
    }

    fun d(){

    }
}

class WorkThread:Thread(){
//    @Volatile
    var isFlag = false
    override fun run() {
        try {
            sleep(100)
        }catch (e:Exception){
            println("interrupted")
        }
        isFlag = true
        println("flag changed $isFlag")
    }
}