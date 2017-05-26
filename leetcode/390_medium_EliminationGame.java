public class Solution {
    public int lastRemaining(int n) {
        int left = 1;
        int right = n;
        int gap = 1;
        boolean fromLeft = true;
        while (left != right) {
            int size = (right - left) / gap + 1;
            if (fromLeft) {
                left = left + gap;
                right = size % 2 == 0 ? right : right - gap;
            } else {
                right = right - gap;
                left = size % 2 == 0 ? left : left + gap;
            }
            fromLeft = !fromLeft;
            gap = gap << 1;
        }
        return left;
    }
}
