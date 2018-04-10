class Solution {
    public int singleNonDuplicate(int[] nums) {
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            int middle = begin + (end - begin) / 2;
            if (middle % 2 == 0) {
                if (nums[middle] == nums[middle + 1]) begin = Math.min(middle + 2, end);
                else end = middle;
            } else {
                if (nums[middle] != nums[middle + 1]) begin = middle + 1;
                else end = Math.max(middle - 1, begin);
            }
        }
        return nums[begin];
    }
}
