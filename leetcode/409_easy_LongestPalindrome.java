class Solution {
    public int longestPalindrome(String s) {
        int[] counter = new int[256];
        for (char c : s.toCharArray()) counter[c]++;
        boolean hasSingle = false;
        int len = 0;
        for (int n : counter) {
            if (n > 0) {
                len += n / 2;
                hasSingle = hasSingle || (n % 2 == 1);
            }
        }
        return len * 2 + (hasSingle ? 1 : 0);
    }
}
