public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxSum = nums[0];
        int currentSum = 0;
        for (int n : nums) {
            if (currentSum <= 0) currentSum = n;
            else currentSum += n;
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
