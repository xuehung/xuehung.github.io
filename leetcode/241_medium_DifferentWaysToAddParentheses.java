public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        int opIdx = findNextOp(input, 0);
        if (opIdx < 0) {
            result.add(Integer.valueOf(input));
        } else {
            while (opIdx > 0) {
                List<Integer> result1 = diffWaysToCompute(input.substring(0, opIdx));
                List<Integer> result2 = diffWaysToCompute(input.substring(opIdx + 1));
                char op = input.charAt(opIdx);
                for (int n : result1) {
                    for (int m : result2) {
                        result.add(getResult(op, n, m));
                    }
                }
                opIdx = findNextOp(input, opIdx + 1);
            }
        }
        return result;
    }
    private int getResult(char op, int a, int b) {
        if (op == '+') return (a + b);
        else if (op == '-') return (a - b);
        else return (a * b);
    }
    private int findNextOp(String input, int begin) {
        for (int i = begin ; i < input.length() ; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '*') return i;
            if (c == '-' && i > 0) {
                char pc = input.charAt(i - 1);
                if (pc >= '0' && pc <= '9') return i;
            }
        }
        return -1;
    }
}
