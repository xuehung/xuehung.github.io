// Importance:xxxx
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0; 
        for (int n : nums) sum += n;
        if (sum % k != 0 || k == 0 || nums.length == 0) return false;
        return _helper(nums, new boolean[nums.length], 0, k, 0, sum / k);
    }

    private boolean _helper(int[] nums, boolean[] visited, int startIdx, int k, int currSum, int target) {
        if (k == 0) return true;
        if (currSum == target) return _helper(nums, visited, 0, k - 1, 0, target);
        for (int i = startIdx ; i < nums.length ; i++) {
            if (!visited[i]) {
                int sum = nums[i] + currSum;
                if (sum <= target) {
                    visited[i] = true;
                    if (_helper(nums, visited, i + 1, k, sum, target)) return true;
                    visited[i] = false;
                }
            }
        }
        return false;
    }
}
