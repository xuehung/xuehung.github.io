class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length < k) return 0;
        double maxSum = 0;
        double sum = 0;
        for (int i = 0 ; i < k ; i++) sum += nums[i];
        maxSum = sum;
        for (int i = k ; i < nums.length ; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum / k;
    }
}
