public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        for (int i = 0 ; i < dp.length ; i++) {
            dp[i] = nums[i];
            dp[i] += Math.max(i - 2 >= 0 ? dp[i - 2] : 0, i - 3 >= 0 ? dp[i - 3] : 0);
        }
        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
