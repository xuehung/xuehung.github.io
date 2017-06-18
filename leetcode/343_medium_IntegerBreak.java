// Importance: x
// Use magical number 3 to do faster
public class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2 ; i <= n ; i++) {
            if (i != n) dp[i] = i;
            for (int k = 1 ; k < i ; k++) {
                dp[i] = Math.max(dp[i], dp[k] * dp[i - k]);
            }
        }
        return dp[n];
    }
}
