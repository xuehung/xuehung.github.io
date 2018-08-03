// Google
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[256];
        int oddCount = 0;
        for (char c : s.toCharArray()) {
            count[c]++;
            oddCount += (count[c] % 2 == 0 ? -1 : 1);
        }
        return oddCount <= 1;
    }
}
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) count[c]++;
        boolean hasOdd = false;
        for (int i = 0 ; i < 256 ; i++) {
            if (count[i] % 2 == 1) {
                if (hasOdd) return false;
                hasOdd = true;
            }
        }
        return true;
    }
}
