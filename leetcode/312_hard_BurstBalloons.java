// Importance:xxxx
class Solution {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[][] dp = new int[len][len];
        for (int w = 0 ; w < len ; w++) {
            for (int i = 0, j = w ; j < len ; i++, j++) {
                int max = 0;
                for (int k = i ; k <= j ; k++) {
                    int coin = nums[k] * (i > 0 ? nums[i - 1] : 1) * (j < len - 1 ? nums[j + 1] : 1);
                    if (k != j) coin += dp[k + 1][j];
                    if (k != i) coin += dp[i][k - 1];
                    max = Math.max(max, coin);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][len - 1];
    }
}
