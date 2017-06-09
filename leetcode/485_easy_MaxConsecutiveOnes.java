public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int len = 0;
        for (int n : nums) {
            if (n == 0) {
                maxLen = Math.max(len, maxLen);
                len = 0;
            } else {
                len++;
            }
        }
        return Math.max(len, maxLen);
    }
}
