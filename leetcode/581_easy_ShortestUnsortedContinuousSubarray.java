public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = new int[nums.length];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        Arrays.sort(copy);
        int same = 0;
        for (int i = 0 ; i < nums.length && copy[i] == nums[i] ; i++) {
            same++;
        }
        int bound = same;
        for (int i = nums.length - 1; i > bound && copy[i] == nums[i] ; i--) {
            same++;
        }
        return nums.length - same;
    }
}
