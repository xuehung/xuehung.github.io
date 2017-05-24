// Importance: x
public class Solution {
    public int maxRotateFunction(int[] A) {
        int len = A.length;
        int sum = 0;
        int max = 0;
        for (int i = 0 ; i < len ; i++) {
            max += i * A[i];
            sum += A[i];
        }
        int currentTotal = max;
        for (int i = 1 ; i < len ; i++) {
            currentTotal = currentTotal + sum - A[len - i] * len;
            max = Math.max(max, currentTotal);
        }
        return max;
    }
}
