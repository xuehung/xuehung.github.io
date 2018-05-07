// Importance:xxxxxx
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null ^ p == null) return false;
        if (s == null && p == null) return true;
        int slen = s.length();
        int plen = p.length();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        for (int i = 0 ; i <= slen ; i++) {
            for (int j = 1 ; j <= plen ; j++) {
                char pc = p.charAt(j - 1) ;
                if (pc != '*') {
                    if (i > 0 && (pc == '.' || pc ==  s.charAt(i - 1))) dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (j >= 2) dp[i][j] |= dp[i][j - 2]; // match none
                    if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                        if (j >= 1) dp[i][j] |= dp[i][j - 1]; // match one
                        if (i >= 1 && j >= 2) dp[i][j] |= dp[i - 1][j]; // match multiple
                    }
                }
            }
        }
        return dp[slen][plen];
    }
}
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null ^ p == null) return false;
        if (s == null && p == null) return true;
        int wildIdx = p.indexOf("*");
        if (wildIdx < 0) {
            if (s.length() != p.length()) return false;
            for (int i = 0 ; i < s.length() ; i++) {
                if (p.charAt(i) != '.' && p.charAt(i) != s.charAt(i)) return false;
            }
            return true;
        }
        int prevLen = wildIdx - 1;
        String sp = p.substring(prevLen + 2);
        char prev = p.charAt(prevLen);

        if (s.length() < prevLen) return false;
        if (!isMatch(s.substring(0, prevLen), p.substring(0, prevLen))) return false;
        if (isMatch(s.substring(prevLen), sp)) return true;
        for (int i = prevLen ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (prev != '.' && prev != c) return false;
            if (isMatch(s.substring(i + 1), sp)) return true;
        }
        return false;
    }
}
class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null ^ p == null) return false;
        if (s == null && p == null) return true;
        if (s.equals(p)) return true;

        int dotIdx = p.indexOf('.');
        int wildcardIdx = p.indexOf('*');
        if (dotIdx >= 0 || wildcardIdx >= 0) {
            int idx = dotIdx >= 0 && wildcardIdx >= 1 ? 
                Math.min(dotIdx, wildcardIdx - 1) : 
                Math.max(dotIdx, wildcardIdx - 1);
            if (idx > 0) {
                if (idx > s.length()) return false;
                return s.substring(0, idx).equals(p.substring(0, idx)) &&
                    isMatch(s.substring(idx),
                            p.substring(idx));
            } else if (wildcardIdx == 1) {
                String pWithOutWildcard = p.substring(wildcardIdx + 1);
                char pc = p.charAt(0);
                for (int i = 0 ; i <= s.length() ; i++) {
                    if (i != 0 && pc != '.' && s.charAt(i - 1) != pc) {
                        return false;
                    }
                    if (isMatch(s.substring(i), pWithOutWildcard)) return true;
                }
            } else {
                if (s.length() < 1) return false;
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        return false;
    }
}
