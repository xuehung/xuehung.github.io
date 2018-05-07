// importance:xxxx
// Google
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int n : nums) {
            if (map.containsKey(n)) continue;
            int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
            int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;
            int len = left + right + 1;
            maxLen = Math.max(maxLen, len);
            map.put(n - left, len);
            map.put(n + right, len);
            map.put(n, len);
        }
        return maxLen;
    }
}
