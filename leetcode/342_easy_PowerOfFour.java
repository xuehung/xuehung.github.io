public class Solution {
    public boolean isPowerOfFour(int num) {
        for (int i = 0 ; i < 32 ; i+=2) {
            if (((num >> i) == 1) && ((num - 1) & num) == 0) return true;
        }
        return false;
    }
}
