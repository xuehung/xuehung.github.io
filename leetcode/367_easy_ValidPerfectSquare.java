class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = Math.max(num / 2, 1);
        long middle = 0;
        while (left < right) {
            middle = (right - left) / 2 + left;
            long square = middle * middle;
            if (square == (long)num) return true;
            else if (square < (long)num) left = (int)middle + 1;
            else right = (int)middle - 1;
        }
        return left * left == num ? true : false;
    }
}
