public class Solution {
    public int reverseBits(int n) {
        int[] mapping = new int[4];
        mapping[0] = 0;
        mapping[1] = 2;
        mapping[2] = 1;
        mapping[3] = 3;
        int reverse = 0;
        for (int i = 0 ; i < 16 ; i++) {
            int subBit = n & 0x3;
            reverse = reverse << 2;
            reverse = reverse | mapping[subBit];
            n = n >> 2;
        }
        return reverse;
    }
}
