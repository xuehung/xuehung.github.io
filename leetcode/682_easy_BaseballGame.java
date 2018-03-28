class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
            if ("C".equals(s)) stack.pop();
            else if ("D".equals(s)) stack.push(stack.peek() * 2);
            else if ("+".equals(s)) {
                int n1 = stack.pop();
                int n2 = stack.peek();
                stack.push(n1);
                stack.push(n1 + n2);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        int sum = 0;
        for (int n : stack) sum += n;
        return sum;
    }
}
