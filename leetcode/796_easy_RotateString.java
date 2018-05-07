class Solution {
    public boolean rotateString(String A, String B) {
        if (A == null && B == null) return true;
        if (A == null || B == null) return false;
        if (A.length() != B.length()) return false;
        if (A.equals(B)) return true;
        for (int i = 0 ; i < A.length() ; i++) {
            if (B.equals(A.substring(i) + A.substring(0, i))) {
                return true;
            }
        }
        return false;
    }
}
