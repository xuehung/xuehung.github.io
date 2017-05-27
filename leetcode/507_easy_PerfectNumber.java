public class Solution {
    public boolean checkPerfectNumber(int num) {
        int sum = num - 1;
        for (int i = (int)Math.sqrt(num) ; i >= 2 ; i--) {
            if (num % i == 0) {
                sum -= i;
                sum -= (num / i);
            }
            if (sum == 0) return true;
            else if (sum < 0) return false;
        }
        return false;
    }
}
