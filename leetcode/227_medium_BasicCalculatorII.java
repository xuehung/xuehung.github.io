// Importance:xxx
class Solution {
    public int calculate(String s) {
        int eval = 0;
        int idx = 0;
        int currVal = 0;
        int prev = 0;
        char op = '+';
        while (idx < s.length()) {
            char c = s.charAt(idx);
            boolean isDigit = c >= '0' && c <= '9';
            if (isDigit) {
                currVal = currVal * 10 + (c - '0');
            }
            if ((c != ' ' && !isDigit) || idx == s.length() - 1) {
                if (op == '-') {
                    eval -= currVal;
                    prev = -currVal;
                } else if (op == '+') {
                    eval += currVal;
                    prev = currVal;
                } else if (op == '*') {
                    eval = eval - prev + prev * currVal;
                    prev = prev * currVal;
                } else if (op == '/') {
                    eval = eval - prev + prev / currVal;
                    prev = prev / currVal;
                }
                op = c;
                currVal = 0;
            }
            idx++;
        }
        return eval;
    }
}
