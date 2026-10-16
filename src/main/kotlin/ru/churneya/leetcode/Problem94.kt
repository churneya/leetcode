package ru.churneya.leetcode


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Problem94 {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        return inorderTraversal(root.left) +
            root.`val` +
            inorderTraversal(root.right)
    }
}

fun main() {
    val solution = Problem94()
    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right!!.left = TreeNode(3)
    check(solution.inorderTraversal(root) == listOf(1, 3, 2))
}
