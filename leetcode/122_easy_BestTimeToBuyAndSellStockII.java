public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int prePrice = Integer.MAX_VALUE;
        for (int p : prices) {
            if (p > prePrice) {
                profit += (p - prePrice);
            }
            prePrice = p;
        }
        return profit;
    }
}
