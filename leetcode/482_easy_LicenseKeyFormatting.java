class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = S.length() - 1 ; i >= 0 ; i--) {
            char c = S.charAt(i);
            if (c == '-') continue;
            if (c >= 'a' && c <= 'z') c = (char)('A' + (c - 'a'));
            if (count++ == 0 && sb.length() != 0) sb.append('-');
            if (count == K) count = 0;
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
