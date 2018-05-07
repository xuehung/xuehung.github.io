class Solution {
    public int countBinarySubstrings(String s) {
        int count = 0;
        int prevLen = 0;
        int len = 1;
        for (int i = 1 ; i < s.length() ; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                len++;
            } else {
                prevLen = len;
                len = 1;
            }
            if (len <= prevLen) count++;
        }
        return count;
    }
}
