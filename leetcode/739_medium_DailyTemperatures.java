class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] output = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1 ; i >= 0 ; i--) {
            int t = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] <= t) stack.pop();
            output[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return output;
    }
}
