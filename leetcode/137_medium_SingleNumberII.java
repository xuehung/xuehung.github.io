public class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int n : nums) {
            for (int i = 0 ; i < 32 ; i++) {
                if ((n & 1) != 0) bits[i]++;
                n = n >> 1;
            }
        }
        int answer = 0;
        for (int i = 31 ; i >= 0 ; i--) {
            answer = answer << 1;
            if (bits[i] % 3 != 0) {
                answer |= 1;
            }
        }
        return answer;
    }
}
