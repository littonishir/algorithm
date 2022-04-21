package leetcode

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */

fun main() {
    val nums = intArrayOf(12, 7, 9, 3, 1, 20)
    val rob1 = rob1(nums)
    val rob2 = rob2(nums)
    println(rob1)
    println(rob2)
}

/**
 * 解题思路
 * 比较 第i-1房子中的钱和 第i-2房子 + i间房子的钱 那个大存那个
 * 最终数组的的最后一个值即可以抢到最多的钱
 * 推导出公式 rob[i] = Math.max(rob[i-1],rob[i-2]+num[i-1])
 */
fun rob1(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    val r = IntArray(nums.size + 1)
    r[0] = 0
    r[1] = nums[0]
    for (i in 2 until r.size) {
        r[i] = Math.max(r[i - 1], r[i - 2] + nums[i - 1])
    }
    return r[nums.size]
}

/**
 * 解题思路
 * 和上面的解法思路一致，只是优化掉了新数组。
 * 滚动数组的思想
 */
fun rob2(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    var first = nums[0]
    var second = Math.max(nums[0], nums[1])
    var temp: Int
    for (i in 2 until nums.size) {
        temp = second
        second = Math.max(second, first + nums[i])
        first = temp
    }
    return second
}