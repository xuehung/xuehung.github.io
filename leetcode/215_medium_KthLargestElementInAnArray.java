// Importance:xxx
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
        for (int n : nums) {
            lo = Math.min(lo, n);
            hi = Math.max(hi, n);
        }
        while (lo < hi) {
            int middle = lo + (hi - lo + 1) / 2;
            int count = 0;
            for (int n : nums) {
                if (n >= middle) count++;
            }
            if (count >= k) lo = middle;
            else hi = middle - 1;
        }
        return lo;
    }
}
