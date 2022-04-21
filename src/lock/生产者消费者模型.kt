package lock

import java.util.concurrent.locks.ReentrantLock

class Tea {
    val maxSize = 10
    val list = ArrayList<String>()
    val o = Object()
    val lock = ReentrantLock()

    fun put(tea: String) {
        synchronized(o) {
            if (list.size == maxSize) {
                try {
                    o.wait()
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            } else {
                list.add(tea)
                o.notifyAll()
                println("${Thread.currentThread().name} 生产者生产茶叶 当前数量：${list.size}")
            }
        }

    }

    fun take() {
        synchronized(o) {
            if (list.size > 0) {
                list.removeAt(0)
                o.notifyAll()
                println("${Thread.currentThread().name} 消费者消费茶叶 当前数量：${list.size}")
            } else {
                try {
                    o.wait()
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }

    }

    fun put1(tea: String) {
        if (list.size == maxSize) return
        lock.lock()
        list.add(tea)
        println("${Thread.currentThread().name} 生产者生产茶叶 当前数量：${list.size}")
        lock.unlock()
    }

    fun take1() {
        lock.lock()
        if (list.size > 0) {
            list.removeAt(0)
            println("${Thread.currentThread().name} 消费者消费茶叶 当前数量：${list.size}")
        }
        lock.unlock()
    }
}