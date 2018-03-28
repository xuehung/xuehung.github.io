class Solution {
    public int dominantIndex(int[] nums) {
        int max = -1;
        for (int n : nums) max = Math.max(n, max);
        int idx = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (max == nums[i]) idx = i;
            else if (max < nums[i] * 2) return -1;
        }
        return idx;
    }
}
