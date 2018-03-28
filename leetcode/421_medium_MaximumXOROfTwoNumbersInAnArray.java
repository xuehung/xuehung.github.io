// Importance:xxx
class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0;
        int max = 0;
        for (int i = 31 ; i >= 0 ; i--) {
            int bitMask = 1 << i;
            mask = mask | bitMask;
            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                set.add(n & mask);
            }
            int target = max | bitMask;
            for (int n : set) {
                if (set.contains(target ^ n)) {
                    max = target;
                    break;
                }
            }
        }
        return max;
    }
}
