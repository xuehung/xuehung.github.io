// Importance:xxxxx

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
