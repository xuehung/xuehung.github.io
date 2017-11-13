// Importance: xx
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) return middle;
            if (nums[middle] >= nums[left]) {
                if (nums[middle] >= target && nums[left] <= target) right = middle;
                else left = middle + 1;
            } else {
                if (nums[middle] <= target && nums[right] >= target) left = middle + 1;
                else right = middle;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
