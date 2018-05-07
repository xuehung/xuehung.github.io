// Importance:xxxx
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int[] buy = new int[len];
        int[] sell = new int[len];
        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], -prices[1]);
        sell[0] = 0;
        sell[1] = Math.max(sell[0], prices[1] - prices[0]);
        for (int i = 2 ; i < len ; i++) {
            int p = prices[i];
            buy[i] = Math.max(buy[i - 1], sell[i - 2] - p);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + p);
        }
        return Math.max(sell[len - 1], 0);
    }
}
