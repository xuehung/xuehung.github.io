// Importance:xxxx
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] stack = new int[len];
        int s = 0;
        for (int n : nums) {
            if (s == 0 || stack[s - 1] < n) stack[s++] = n;
            else {
                int lo = 0, hi = s - 1;
                while (lo < hi) {
                    int mi = lo + (hi - lo) / 2;
                    if (stack[mi] < n) lo = mi + 1;
                    else hi = mi;
                }
                stack[lo] = n;
            }
        }
        return s;
    }
}
