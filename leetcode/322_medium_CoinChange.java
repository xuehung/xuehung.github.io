// Importance:xxx
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1 ; i <= amount ; i++) {
            for (int c : coins) {
                if (i == c) dp[i] = 1;
                else if (i > c) {
                    if (dp[i - c] != 0) dp[i] = dp[i] == 0 ? dp[i - c] + 1 : Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
