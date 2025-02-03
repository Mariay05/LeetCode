class Solution {
    fun maxProfit(prices: IntArray): Int {
        var maxPrice = 0
        var maxDiff = 0

        for (i in prices.size - 1 downTo 0) {
            val price = prices[i]
            maxDiff = maxOf(maxDiff, maxPrice - price)
            maxPrice = maxOf(maxPrice, price)
        }

        return maxDiff
    }
}