// Importance: x
// do it without loop
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 1) return n == 1;
        while (n % 3 == 0) {
            n /= 3;
            if (n == 1) return true;
        }
        return false;
    }
}
