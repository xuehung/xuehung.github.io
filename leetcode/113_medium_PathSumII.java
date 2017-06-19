public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        helper(root, stack, 0, sum, result);
        return result;
    }
    private void helper(TreeNode root, Stack<Integer> stack, int sum, int target, List<List<Integer>> result) {
        if (root == null) return;
        sum += root.val;
        stack.push(root.val);
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<>(stack));
            }
        }
        helper(root.left, stack, sum, target, result);
        helper(root.right, stack, sum, target, result);
        stack.pop();
    }
}
