// Importance:xx
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;
        int sum = 0;
        int[] sumToLeft = new int[len], sumToRight = new int[len];
        for (int i = 0 ; i < len ; i++) {
            sumToLeft[i] = sum;
            sum += nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        sum = 0;
        for (int i = len - 1 ; i >= 0 ; i--) {
            if (!map.containsKey(sum)) map.put(sum, i);
            sum += nums[i];
        }
        int maxLen = 0;
        for (int i = 0 ; i < len ; i++) {
            int target = sum - k - sumToLeft[i];
            if (map.containsKey(target)) maxLen = Math.max(maxLen, map.get(target) - i + 1);
        }
        return maxLen;
    }
}
