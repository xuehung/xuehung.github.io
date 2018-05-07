// Importance:xxx
// Google
class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int i = 31 ; i >= 0 ; i--) {
            int newMax = max | (1 << i);
            int mask = ~((1 << i) - 1);
            Set<Integer> set = new HashSet<>();
            for (int n : nums) {
                if (set.contains(n & mask)) {
                    max = newMax;
                    break;
                }
                set.add((n & mask) ^ newMax);
            }
        }
        return max;
    }
}
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
