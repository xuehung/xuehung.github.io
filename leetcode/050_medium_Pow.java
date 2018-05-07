// Importance:xx
// Google
class Solution {
    public double myPow(double x, int n) {
        return _myPow(x, n);
    }
    public double _myPow(double x, long n) {
        if (n < 0) return _myPow(1/x, -n);
        double result = 1;
        while (n > 0) {
            if (n % 2 == 1) result *= x;
            x *= x;
            n /= 2;
        }
        return result;
    }
}
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
