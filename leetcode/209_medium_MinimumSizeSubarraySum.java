// Importance:x
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int minLen = nums.length + 1;
        int currLen = 0;
        int sum = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            sum += nums[i];
            currLen++;
            while (sum >= s) {
                minLen = Math.min(minLen, currLen);
                sum -= nums[i - currLen + 1];
                currLen--;
            }
        }
        return minLen <= nums.length ? minLen : 0;
    }
}
