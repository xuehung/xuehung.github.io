class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0 || len2 == 0) return Math.max(len1, len2);
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1 ; i <= len1 ; i++) dp[i][0] = i;
        for (int i = 1 ; i <= len2 ; i++) dp[0][i] = i;
        for (int i = 1 ; i <= len1 ; i++) {
            for (int j = 1 ; j <= len2 ; j++) {
                dp[i][j] = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
            }
        }
        return dp[len1][len2];
    }
}
