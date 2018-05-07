class Solution {
    public boolean isSubsequence(String s, String t) {
        int si = 0;
        for (int ti = 0 ; ti < t.length() ; ti++) {
            if (si < s.length() && t.charAt(ti) == s.charAt(si)) {
                si++;
            }
        }
        return si == s.length();
    }
}
