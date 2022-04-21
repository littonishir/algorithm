package lock

import java.util.concurrent.CountDownLatch

fun main() {

//    joinTest()
    countDownLatchTest()
//    Thread.sleep(90000)


}

/**
 *
 */
fun countDownLatchTest(){
    var name = ""
    var age = 0
    val countDownLatch = CountDownLatch(2)
    val a = Thread{
        name = "cc"
        Thread.sleep(1000)
        println("${Thread.currentThread().name} 昵称更新完毕")
        countDownLatch.countDown()
    }
    val b = Thread{
        age = 18
        Thread.sleep(2000)
        println("${Thread.currentThread().name} 年龄更新完毕")
        countDownLatch.countDown()
    }
    val c = Thread{
        countDownLatch.await()
        println("${Thread.currentThread().name} 人物创建完毕 昵称:$name;年龄:$age")
    }
    a.start()
    b.start()
    c.start()

}

/**
 * join方法
 * 将线程B加入到线程A的尾部，当A执行完后B才执行
 */
fun joinTest() {
    val a = Thread {
        for (i in 0..10) {
            println("${Thread.currentThread().name} 输出信号$i")
        }
    }
    val b = Thread {
        println("${Thread.currentThread().name} 测试任务完成")
    }
    a.start()
    a.join()
    b.start()
}