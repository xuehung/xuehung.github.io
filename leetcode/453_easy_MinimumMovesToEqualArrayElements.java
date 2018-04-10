class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 0) return 0;
        int sum = 0;
        int min = nums[0];
        for (int n : nums) {
            sum += n;
            min = Math.min(min, n);
        }
        return sum - min * nums.length;
    }
}
