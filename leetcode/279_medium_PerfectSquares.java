// Importance: x
public class Solution {
    public int numSquares(int n) {
        int[] sol = new int[n + 1];
        for (int m = 0 ; m <= n ; m++) {
            int tempMin = m;
            for (int i = 1 ; i * i <= m ; i++) {
                tempMin = Math.min(tempMin, sol[m - i * i] + 1);
            }
            sol[m] = tempMin;
        }
        return sol[n];
    }
}
