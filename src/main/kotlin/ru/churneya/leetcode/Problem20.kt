package ru.churneya.leetcode

class Problem20 {
    fun isValid(s: String): Boolean {
        val map = mapOf('{' to '}', '[' to ']', '(' to ')')
        val deque = ArrayDeque<Char>()

        s.forEach {
            if (it in map.keys) {
                deque.addLast(it)
            } else {
                if (deque.isEmpty())
                    return false

                val last = deque.removeLast()
                if (map[last] != it) {
                    return false
                }
            }

        }
        return deque.isEmpty()
    }
}

fun main() {
    val solution = Problem20()
    check(solution.isValid("()"))
    check(solution.isValid("()[]{}"))
    check(!solution.isValid("(]"))
}