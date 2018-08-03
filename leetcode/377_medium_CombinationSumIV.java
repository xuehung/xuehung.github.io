// Importance:xxxxx
// Google
class Solution {
    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if(dp[target] != -1) {
            return dp[target];
        }

        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }

        dp[target] = res;
        return res;
    }
}
class Solution {
    int ans = 0;
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1 ; i <= target ; i++) {
            for (int n : nums) {
                if (n <= i) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }

}
