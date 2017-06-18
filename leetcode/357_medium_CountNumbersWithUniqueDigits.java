public class Solution {
    private int total = 0;
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int count = 0;
        for (int i = 1 ; i <= n ; i++) {
            count += helper2(i);
        }
        return count;
    }
    private int helper2(int n) {
        if (n == 1) return 10;
        if (n == 2) return 81;
        if (n > 10) return 0;
        int digits = 8;
        int count = 81;
        for (int i = 2 ; i < n ; i++) count *= digits--;
        return count;
    }
}
