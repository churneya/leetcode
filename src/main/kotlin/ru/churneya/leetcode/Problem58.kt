package ru.churneya.leetcode

class Problem58 {
    fun lengthOfLastWord(s: String): Int {
        var result = 0
        for (i in s.length - 1 downTo 0) {
            if(s[i] != ' '){
                result++
            }else{
                if(result == 0) {
                    continue
                }
                break
            }
        }
        return result
    }
}

fun main() {
    val solution = Problem58()
    check(solution.lengthOfLastWord("Hello World")  == 5)
    check(solution.lengthOfLastWord("   fly me   to   the moon  ") == 4)
    check(solution.lengthOfLastWord("luffy is still joyboy") == 6)
}