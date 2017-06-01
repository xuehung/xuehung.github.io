public class Solution {
    public int singleNumber(int[] nums) {
        int out = 0;
        for (int n : nums) out = out ^ n;
        return out;
    }
}
