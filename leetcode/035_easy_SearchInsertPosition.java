public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left != right) {
            int middle = left + (right - left) / 2;
            int n = nums[middle];
            if (n == target) return middle;
            else if (n < target) left = middle + 1;
            else right = middle;
        }
        return nums[left] < target ? left + 1 : left;
    }
}
