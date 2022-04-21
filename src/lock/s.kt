package lock

import java.util.concurrent.locks.ReentrantLock

fun main() {
//    val arrayList = ArrayList<String>()
//    val lock = ReentrantLock()
//
//    for (i in 0..100){
//        Thread(Runnable {
//            while (true){
//                if (arrayList.size < 10) {
//                    arrayList.add("产品")
//                    println("添加产品产品，${arrayList.size}")
//                }else{
//                }
//            }}).start()
//
//    }
//    Thread {
//        while (true){
//            if (arrayList.size > 0) {
//                arrayList.removeAt(0)
//                println("移除产品产品，${arrayList.size}")
//
//            }
//        }
//    }.start()

    val breadContainer = Tea()
    Thread{
        while (true){
            Thread.sleep(300)
            breadContainer.put1("br")
        }
    }.start()
    Thread{
        while (true){
            Thread.sleep(1000)
            breadContainer.take1()
        }
    }.start()
    Thread{
        while (true){
            Thread.sleep(1000)
            breadContainer.take1()
        }
    }.start()
    Thread{
        while (true){
            Thread.sleep(1000)
            breadContainer.take1()
        }
    }.start()
    Thread{
        while (true){
            Thread.sleep(1000)
            breadContainer.take1()
        }
    }.start()


//    Thread(r1, "生产者2").start()
//    Thread(r1, "生产者3").start()
//    Thread(r1, "生产者4").start()
//    Thread(r1, "生产者5").start()
//    Thread(r1, "生产者6").start()
//    Thread(r1, "生产者7").start()





}