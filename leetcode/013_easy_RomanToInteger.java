class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            boolean isPlus = true;
            int val = getVal(s.charAt(i));
            if (i + 1 < s.length() && getVal(s.charAt(i + 1)) > val) isPlus = false;
            sum = sum + (isPlus ? 1 : -1) * val;
        }
        return sum;
    }
    private int getVal(char c) {
        if (c == 'I') return 1;
        if (c == 'V') return 5;
        if (c == 'X') return 10;
        if (c == 'L') return 50;
        if (c == 'C') return 100;
        if (c == 'D') return 500;
        if (c == 'M') return 1000;
        return 0;
    }
}
