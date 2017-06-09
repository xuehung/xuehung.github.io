public class Solution {
    public int findComplement(int num) {
        int output = 0;
        int bit = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                output |= (1 << bit);
            }
            bit++;
            num = num >> 1;
        }
        return output;
    }
}
