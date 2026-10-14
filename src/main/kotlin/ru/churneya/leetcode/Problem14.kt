package ru.churneya.leetcode

class Problem14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        var prefix = ""
        val minWordLength = strs.minOf { it.length }

        outer@ for (i in 0..<minWordLength) {
            prefix += strs[0][i]
            for (word in strs) {
                if (word[i] != prefix[i]) {
                    prefix = prefix.subSequence(0, i).toString()
                    break@outer
                }
            }
        }

        return prefix
    }
}

fun main() {
    val solution = Problem14()
    check(solution.longestCommonPrefix(arrayOf("flower", "flow", "flight")) == "fl")
}