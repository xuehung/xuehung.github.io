public class Solution {
    public int arrangeCoins(int n) {
        for (int i = ((int)Math.sqrt(n * 2.0)) + 1 ; i >= 0 ; i--) {
            if ((long)i * (i + 1) / 2 <= n) return i;
        }
        return 0;
    }
}
