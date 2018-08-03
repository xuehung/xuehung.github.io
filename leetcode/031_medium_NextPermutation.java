// Importance:xxx
// Google
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int end = len - 1;
        int begin = end - 1;
        while (begin >= 0 && nums[begin] >= nums[begin + 1]) begin--;
        if (begin < 0) {
            Arrays.sort(nums);
        } else {
            int lo = begin + 1, hi = end;
            while (lo < hi) {
                int mi = lo + (hi - lo) / 2;
                if (nums[mi] > nums[begin]) lo = mi + 1;
                else hi = mi;
            }
            if (nums[lo] <= nums[begin]) lo--;
            int tmp = nums[begin];
            nums[begin] = nums[lo];
            nums[lo] = tmp;
            if (begin + 1 < len - 1) Arrays.sort(nums, begin + 1, len);
        }
    }
}
