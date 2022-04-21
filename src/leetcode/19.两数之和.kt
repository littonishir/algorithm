package leetcode

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
fun main() {
    val listNode = ListNode(1).also { it.next = ListNode(2).also { it.next = ListNode(3).also { it.next = ListNode(4) } } }
    println("ListNodeSize:"+getListNodeSize(listNode))
    val removeN = removeN(listNode, 1)
    getListNodeSize(removeN)


}

fun removeN(listNode: ListNode,n:Int): ListNode {
    var fast = listNode
    var slow = listNode
    var x = n
    while (x>0){
        fast = fast.next!!
        x--
    }
    while (fast.next!=null){
        fast = fast.next!!
        slow = slow.next!!
    }
    slow.next = slow.next?.next

    return listNode





}

fun getListNodeSize(listNode: ListNode): Int {
    var size = 0
    var temp: ListNode = listNode
    while (temp.next != null) {
        size++
        println(temp.value)
        temp = temp.next!!
    }
    println(temp.value)
    return size + 1
}


class ListNode(var any: Any) {
    var value: Any = any
    var next: ListNode? = null
}

/**
 * 由于哈希查找的时间复杂度为 O(1)O(1)，所以可以利用哈希容器 map 降低时间复杂度
 * 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
 * 如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
 * https://leetcode-cn.com/problems/two-sum/
 */
fun twoSum2(nums: IntArray, target: Int): IntArray {
    val mHashMap = HashMap<Int, Int>()
    for (i in nums.indices) {
        if (mHashMap.containsKey(target - nums[i])) {
            return intArrayOf(mHashMap[target - nums[i]]!!, i)
        }
        mHashMap[nums[i]] = i
    }
    return IntArray(0)
}

