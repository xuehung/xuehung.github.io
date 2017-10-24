public class Solution {
    public boolean wordPattern(String pattern, String str) {
        Set<String> used = new HashSet<>();
        String[] mapping = new String[26];
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        for (int i = 0 ; i < pattern.length() ; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            String converted = mapping[c - 'a'];
            if (converted != null && !converted.equals(word)) {
                return false;
            } else if (converted == null) {
                if (used.contains(word)) return false;
                used.add(word);
                mapping[c - 'a'] = word;
            }
        }
        return true;
    }
}
