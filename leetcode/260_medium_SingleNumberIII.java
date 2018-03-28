class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        int[] result = new int[2];
        for (int n : nums) diff = diff ^ n;
        int mask = 1;
        while ((diff & mask) == 0) mask = mask << 1;
        for (int n : nums) {
            if ((n & mask) == 0) result[0] ^= n;
            else result[1] ^= n;
        }
        return result;
    }
}
