package 排序算法

import tool.swap

class 插入排序 {
    /**
     * 插入排序'''''；'''；'''''//。/'【】'、'；'；'；'；'''；'''''''''；；。
     * 对基本有序的数组最好用 【稳定】
     * 时间复杂度：n2
     * 空间复杂度：1
     * 思想：打扑克牌的思想，将拿到的新牌直到插入到合适的位置。
     */
    fun sort(a: IntArray) {
        for (i in 0 until a.size) {
            for (j in i downTo 1)
                if (a[j] < a[j - 1]) {
                    swap(a, j, j - 1)
                }
        }
    }
}



