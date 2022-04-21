package 排序算法

import tool.printArray
import tool.swap

class 冒泡排序 {

    fun sort(a: IntArray) {
        for (i in a.size - 1 downTo 0) {
            findMax(a, i)
        }
    }

    fun findMax(a: IntArray, n: Int) {
        for (j in 0 until n) {
            if (a[j] > a[j + 1]) {
                swap(a, j, j + 1)
            }
        }
    }
}
