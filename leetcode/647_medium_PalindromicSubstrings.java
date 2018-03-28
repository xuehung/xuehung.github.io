class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int count = 0;
        for (int w = 1 ; w <= len ; w++) {
            for (int i = 0, j = i + w - 1 ; j < len ; j++, i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (i + 1 <= j - 1 ? dp[i + 1][j - 1] : true);
                if (dp[i][j]) count++;
            }
        }
        return count;
    }
}
