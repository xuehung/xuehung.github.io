// Importance:xx
class Solution {
    public double myPow(double x, int n) {
        double result = 1;
        long ln = n;
        if (ln < 0) {
            ln = -ln;
            x = 1 / x;
        }
        while (ln > 0) {
            if (ln % 2 == 1) {
                result = result * x;
            }
            x = x * x;
            ln = ln >> 1;
        }
        return result;
    }
}
