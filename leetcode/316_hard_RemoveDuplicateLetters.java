// Importance:xx
class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() <= 1) return s;
        int[] counter = new int[26];
        for (char c : s.toCharArray()) counter[c - 'a']++;
        int minIdx = s.charAt(0) - 'a';
        for (int i = 0 ; i < s.length() ; i++) {
            int idx = s.charAt(i) - 'a';
            if (idx < minIdx) minIdx = idx;
            counter[idx]--;
            if (counter[idx] == 0) break;
        }
        char c = (char)(minIdx + 'a');
        int firstCharIdx = s.indexOf(c);
        return s.charAt(firstCharIdx) + removeDuplicateLetters(s.substring(firstCharIdx + 1).replace(String.valueOf(c), ""));
    }
}
