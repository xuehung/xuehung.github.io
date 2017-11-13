// Importance: xx
class Solution {
    public boolean isPalindrome(int x) {
            if (x >= 0 && x < 10) return true;
            if (x < 0 || x % 10 == 0) return false;
            int half = 0;
            while (half < x) {
                        half = half * 10 + x % 10;
                        x /= 10;
                    }
            return half == x || (half / 10 == x);
        }
}
