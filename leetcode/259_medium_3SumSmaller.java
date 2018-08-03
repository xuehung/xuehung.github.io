// Importance:xx
// Google
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i++) {
            int j = i + 1, k = nums.length - 1;
            int remain = target - nums[i];
            while (j < k) {
                if (nums[j] + nums[k] < remain) {
                    count += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }
        return count;
    }
}
