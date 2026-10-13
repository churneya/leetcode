package ru.churneya.leetcode

class Problem13 {
    fun romanToInt(s: String): Int {
        val dict = mapOf('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)
        var final = 0
        for (i in 0..<s.length) {
            val currentDigit = dict[s[i]]!!
            if (i + 1 == s.length) {
                final += currentDigit
                continue
            }
            val nextDigit = dict[s[i + 1]]!!
            if (currentDigit >= nextDigit) {
                final += currentDigit
            } else {
                final -= currentDigit
            }
        }
        return final
    }
}

fun main() {
    val solution = Problem13()
    check(solution.romanToInt("III") == 3)
    check(solution.romanToInt("LVIII") == 58)
    check(solution.romanToInt("IV") == 4)
    check(solution.romanToInt("MCMXCIV") == 1994)
}