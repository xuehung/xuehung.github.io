// Importance:xxxx
class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        char[] carr = s.toCharArray();
        for (int i = 1 ; i <= 26 ; i++) ans = Math.max(ans, maxValidSubstring(carr, k, i));
        return ans;
    }

    private int maxValidSubstring(char[] carr, int k, int charCount) {
        int[] count = new int[26];
        int left = 0, right = 0;
        int uniq = 0, reachK = 0;
        int maxLen = 0;
        while (right < carr.length) {
            if (uniq <= charCount) {
                int idx = carr[right] - 'a';
                if (count[idx] == 0) uniq++;
                if (++count[idx] == k) reachK++;
                right++;
            } else {
                int idx = carr[left] - 'a';
                if (count[idx] == k) reachK--;
                if (--count[idx] == 0) uniq--;
                left++;
            }
            if (uniq == charCount && reachK == charCount) maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
