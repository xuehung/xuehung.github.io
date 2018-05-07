// Importance:xxxxx
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0 ; i < nums.length ; i++) {
            if (i > k) set.remove((long)nums[i - k - 1]);
            long val = (long)nums[i];
            Long upper = set.floor(val + t);
            if (upper != null && upper >= val - t) return true;
            set.add(val);
        }
        return false;
    }
}
