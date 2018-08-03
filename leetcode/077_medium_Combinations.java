class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        helper(n, 1, k, new Stack<>(), output);
        return output;
    }

    private void helper(int n, int i, int k, Stack<Integer> stack, List<List<Integer>> output) {
        if (k == 0) {
            output.add(new ArrayList<>(stack));
        }
        while (i <= n) {
            stack.push(i);
            helper(n, i + 1, k - 1, stack, output);
            stack.pop();
            i++;
        }
    }
}
