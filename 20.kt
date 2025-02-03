class Solution {
    fun isValid(s: String): Boolean {
        val openStack = Stack<Char>()
        for (c in s) {
            when {
                isOpen(c) -> openStack.push(c)
                isClose(c) -> {
                    if (openStack.isEmpty()) return false
                    val lastOpen = openStack.pop()
                    if (!type(left = lastOpen, right = c)) return false
                }
                else -> return false
            }
        }
        return openStack.isEmpty()
    }

    fun isOpen (c: Char): Boolean {
        return c == '('  || c =='['  || c == '{'
    }

    fun isClose (c: Char): Boolean {
        return c == ')'  || c == ']' || c == '}'
    }

    fun type (left: Char, right: Char): Boolean {
        return  (left == '(' && right == ')') ||
                (left == '[' && right == ']') ||
                (left == '{' && right == '}')
    }
}