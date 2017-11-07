class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int n : nums) {
            if (n < 0) continue;
            int i = n;
            while (i <= nums.length && i >= 1 && nums[i - 1] != i) {
                int tmp = nums[i - 1];
                nums[i - 1] = i;
                i = tmp;
            }
        }
        for (int i = 0 ; i < nums.length ; i++) {
            System.out.println(nums[i]);
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }
}
