class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int i = 0;
        int pos = -1;
        while (i < haystack.length()) {
            boolean match = true;
            for (int j = 0 ; j < needle.length() ; j++) {
                if (i + j >= haystack.length()) return pos;
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) return i;
            i++;
        }
        return pos;
    }
}
