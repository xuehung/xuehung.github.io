class Solution {
    public int rotatedDigits(int N) {
        int[] dp = new int[N + 1];
        int count = 0;
        for (int i = 1 ; i <= N ; i++) {
            int d = i % 10;
            int prev = i / 10;
            if (d == 2 || d == 5 || d == 6 || d == 9) {
                if (dp[prev] >= 0) dp[i] = 1;
                else dp[i] = -1;
            } else if (d == 0 || d == 1 || d == 8) {
                dp[i] = dp[prev];
            } else {
                dp[i] = -1;
            }
            if (dp[i] == 1) count++;
        }
        return count;
    }
}
