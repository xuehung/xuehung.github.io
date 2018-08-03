// Importance:xx
// Amazon
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int begin = 0;
        int[] loc = new int[256];
        for (int end = 0 ; end < s.length() ; end++) {
            char c = s.charAt(end);
            if (loc[c] - 1 >= begin) {
                begin = loc[c];
            }
            loc[c] = end + 1;
            maxLen = Math.max(end - begin + 1, maxLen);
        }
        return maxLen;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int currentLen = 0;
        Map<Character, Integer> charToIndex = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i ++) {
            char c = s.charAt(i);
            Integer preIndex = charToIndex.get(c);
            if (preIndex == null || preIndex < (i - currentLen)) {
                currentLen++;
            } else {
                currentLen = i - charToIndex.get(c);
            }
            charToIndex.put(c, i);
            maxLen = Math.max(maxLen, currentLen);
        }
        return maxLen;
    }
}
