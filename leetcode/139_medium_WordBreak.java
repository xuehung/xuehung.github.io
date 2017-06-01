public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];
        for (int i = 0 ; i < dp.length ; i++) {
            if (wordSet.contains(s.substring(0, i + 1))) dp[i] = true;
            else {
                for (int j = i - 1 ; j >= 0 ; j--) {
                    if (dp[j] && wordSet.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}
