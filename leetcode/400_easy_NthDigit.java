public class Solution {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        int digits = 1;
        long totalNum = 9;
        int begin = 1;
        while (n > totalNum * digits) {
            n -= totalNum * digits;
            totalNum *= 10;
            digits++;
            begin *= 10;
        }
        int num = begin + (n - 1) / digits;
        int pos = digits - (n - 1) % digits - 1;
        while (pos != 0) {
            pos--;
            num /= 10;
        }
        return num % 10;
    }
}
