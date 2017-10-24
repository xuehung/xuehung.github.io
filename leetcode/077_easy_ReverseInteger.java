class Solution {
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        long positive = x;
        if (sign < 0) positive = -x;
        int reverse = 0;
        while (positive != 0) {
            int newReverse = reverse * 10 + (int)(positive % 10);
            if (newReverse / 10 != reverse) return 0;
            positive /= 10;
            reverse = newReverse;
        }
        return reverse * sign;
    }
}
