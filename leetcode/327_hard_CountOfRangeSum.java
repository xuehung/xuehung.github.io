// Importance:xxx
// Google
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long sum = 0;
        TreeMap<Long, Integer> map = new TreeMap<>();
        map.put(0L, 1);
        int ans = 0;
        for (int n : nums) {
            sum += n;
            Map<Long, Integer> submap = map.subMap(sum - upper, sum - lower + 1);
            for (int v : submap.values()) {
                ans += v;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
