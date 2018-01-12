class Solution {
    public int titleToNumber(String s) {
        int n = 0;
        for (char c : s.toCharArray()) {
            int i = c - 'A' + 1;
            n *= 26;
            n += i;
        }
        return n;
    }
}
