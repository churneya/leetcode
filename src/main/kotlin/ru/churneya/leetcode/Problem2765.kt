package ru.churneya.leetcode


class Problem2765 {
    fun alternatingSubarray(nums: IntArray): Int {
        var len = 0
        var prevDiff = 0

        for (index in 0 until nums.lastIndex) {
            val current = nums[index]
            val next = nums[index + 1]

            val diff = next - current
            if (diff == 1 && (prevDiff == -1 || prevDiff == 0)) {
                len++
            } else if (diff == -1 && prevDiff == 1) {
                len++
            } else {
                len = 0
            }

            prevDiff = diff
        }

        return if (len > 0) {
            len
        } else {
            -1
        }
    }

    fun alternatingSubarrayNew(nums: IntArray): Int {
        var len = 1
        var maxLen = 0
        var prevDiff = 0

        for (index in 0 until nums.lastIndex) {
            val diff = nums[index + 1] - nums[index]

            if (diff == 1 && prevDiff == 0) {
                len = 2
            } else if ((diff == 1 || diff == -1) && diff == -prevDiff) {
                len++
            } else if (diff == 1) {
                len = 2
            } else {
                len = 1
            }

            prevDiff = if (diff == 1 || diff == -1) diff else 0
            maxLen = maxOf(maxLen, len)
        }

        return if (maxLen >= 2) maxLen else -1
    }
}

fun main() {
    val solution = Problem2765()
    check(solution.alternatingSubarrayNew(intArrayOf(2, 3, 4, 3, 4)) == 4)
    check(solution.alternatingSubarrayNew(intArrayOf(4, 5, 6)) == 2)
    check(solution.alternatingSubarrayNew(intArrayOf(42, 43, 44, 43, 44, 43, 44, 45, 46)) == 6)
}
