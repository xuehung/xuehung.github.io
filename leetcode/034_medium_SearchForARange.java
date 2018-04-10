// Importance:xxxxx
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] output = new int[] {-1, -1};
        if (nums.length == 0) return output;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) left = middle + 1;
            else right = middle;
        }
        if (nums[left] == target) output[0] = left;
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left + 1) / 2;
            if (nums[middle] <= target) left = middle;
            else right = middle - 1;
        }
        if (nums[right] == target) output[1] = right;
        return output;
    }
}
