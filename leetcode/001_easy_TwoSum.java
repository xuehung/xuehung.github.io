public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] sol = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length ; i++) {
            int n = nums[i];
            if (map.containsKey(target - n)) {
                sol[0] = map.get(target - n);
                sol[1] = i;
                break;
            }
            map.put(n, i);
        }
        return sol;
    }
}
