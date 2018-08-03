// Google
class Solution {
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int n = (B.length() + A.length() - 1) / A.length();
        for (int i = 0 ; i < n ; i++) {
            sb.append(A);
        }
        if (sb.toString().indexOf(B) >= 0) return n;
        sb.append(A);
        if (sb.toString().indexOf(B) >= 0) return n + 1;
        return -1;
    }
}
