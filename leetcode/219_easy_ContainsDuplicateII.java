// Importance: x
// Can you use Set to solve this problem?
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            int n = nums[i];
            if (map.containsKey(n)) {
                if (i - map.get(n) <= k) return true;
            }
            map.put(n, i);
        }
        return false;
    }
}
