class Solution {
    public int calculate(String s) {
        int sign = 1;
        int output = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int n = 0;
                while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    n = n * 10 + (s.charAt(i) - '0');
                    i++;
                }
                output = output + sign * n;
                i--;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(sign);
                stack.push(output);
                sign = 1;
                output = 0;
            } else if (c == ')') {
                int prevOutput = stack.pop();
                int prevSign = stack.pop();
                output = prevOutput + prevSign * output;
            }
        }
        return output;
    }
}')')}}}
