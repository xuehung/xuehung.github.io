public class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroIdx = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIdx] = nums[i];
                nonZeroIdx++;
            }
            if (i > nonZeroIdx - 1) nums[i] = 0;
        }
    }
}
