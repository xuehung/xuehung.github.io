class Solution {
    public String minWindow(String s, String t) {
        int begin = 0, end = 0;
        int[] counter = new int[256];
        char[] carr = s.toCharArray();
        int uniqChar = 0;
        int matched = 0;
        int head = 0;
        int minLen = s.length() + 1;
        for (char c : t.toCharArray()) {
            if (counter[c]++ == 0) uniqChar++;
        }

        while (end < s.length()) {
            if (--counter[carr[end++]] == 0) matched++;
            while (matched == uniqChar) {
                if (end - begin < minLen) {
                    minLen = end - begin;
                    head = begin;
                }
                minLen = Math.min(minLen, end - begin);
                if (counter[carr[begin++]]++ == 0) matched--;
            }
        }
        return minLen > s.length() ? "" : s.substring(head, head + minLen);
    }
}
