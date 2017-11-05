class Solution {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0) return true;
        int capitalCount = 0;
        for (char c : word.toCharArray()) {
            if (c >= 'A' && c <= 'Z') capitalCount++;
        }
        return capitalCount == word.length() || 
            capitalCount == 0 || 
            (capitalCount == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z');
    }
}
