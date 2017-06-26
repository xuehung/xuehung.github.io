public class Solution {
    public int[] countBits(int num) {
        int[] mapping = new int[] {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
        int[] result = new int[num + 1];
        for (int n = 1 ; n <= num ; n++) {
            int i = n;
            int bit = 0;
            int block = 0;
            while (i != 0 && block++ < 8) {
                bit += mapping[i & 0xf];
                i = i >> 4;
            }
            result[n] = bit;
        }
        return result;
    }
}
