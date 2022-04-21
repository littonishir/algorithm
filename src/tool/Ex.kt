package tool

import 排序算法.*

/**
 * 测试方法
 */
val array1 = intArrayOf(93, 2, 34, 22, 77, 67, 12, 94, 86, 99, 101, 6, 9)

fun main() {
//    冒泡排序().sort(array1)
//    插入排序().sort(array1)
    val quicksort = 快速排序().quickSort(array1.toList())
    print(quicksort)

//    printArray(array1)
}

/**
 * 数组中i和j的元素交换位置
 */
fun swap(a: IntArray, i: Int, j: Int) {
    val temp = a[i]
    a[i] = a[j]
    a[j] = temp
}

fun printArray(a: IntArray) {
    a.forEach {
        print("$it ")
    }
}