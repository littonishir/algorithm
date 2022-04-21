package 排序算法

import tool.swap

class 快速排序 {

    fun quickSort(items:List<Int>):List<Int>{
        // 递归退出条件
        if (items.count() < 2) return items
        // 中轴
        val pivot = items[items.count()/2]
        // 左分区
        val less = items.filter { it < pivot }
        // 右分区
        val greater = items.filter { it > pivot }
        // 拼接分区：左-中轴-右，并对左右分区排序
        return quickSort(less) + pivot + quickSort(greater)
    }

    //2022-03-24 写了两遍
    fun k(list: List<Int>):List<Int>{
        if (list.size<2) return list
        val povit = list[list.size / 2]
        val l = list.filter { it<povit }
        val r = list.filter{it>povit}
        return k(l)+povit+k(r)
    }
    fun quickSort2(items: List<Int>):List<Int>{
        if (items.size<2) return items
        val pivot = items[items.size/2]
        val l = items.filter{it < pivot}
        val r = items.filter{it > pivot}
        return quickSort2(l) + pivot +quickSort2(r)
    }

}






