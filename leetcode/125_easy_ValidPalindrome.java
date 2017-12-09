class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return true;
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < s.length() && !isValid(s.charAt(left))) left++;
            while (right >= 0 && !isValid(s.charAt(right))) right--;
            if (left < right) {
                if (s.charAt(left) != s.charAt(right)) return false;
                left++;
                right--;
            }
        }
        return true;
    }
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
