// Importance:xxxxx
// Google
class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 1 ; len < n ; len++) {
            for (int i = 1 ; i <= n - len ; i++) {
                int min = Integer.MAX_VALUE;
                int end = i + len;
                for (int x = i ; x <= end ; x++) {
                    int left = i <= x - 1 ? dp[i][x - 1] : 0;
                    int right = x + 1 <= end ? dp[x + 1][end] : 0;
                    min = Math.min(min, x + Math.max(left, right));
                }
                dp[i][end] = min;
            }
        }
        return dp[1][n];
    }
}
