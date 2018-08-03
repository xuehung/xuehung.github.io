// Importance:xxxx
// Google
class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int lo = 0, hi = len - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi + 1] < nums[mi]) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (isPeak(nums, left)) return left;
            if (isPeak(nums, right)) return right;
            if (isPeak(nums, middle)) return middle;
            if (nums[middle + 1] > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return left;
    }

    private boolean isPeak(int[] nums, int idx) {
        if (idx > 0 && nums[idx - 1] > nums[idx]) return false;
        if (idx < nums.length - 1 && nums[idx + 1] > nums[idx]) return false;
        return true;
    }
}
