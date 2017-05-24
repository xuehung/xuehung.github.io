public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while (!stack.isEmpty()) {
                Stack<TreeNode> newStack = new Stack<>();
                int max = Integer.MIN_VALUE;
                while (!stack.isEmpty()) {
                    TreeNode node = stack.pop();
                    max = Math.max(max, node.val);
                    if (node.left != null) newStack.push(node.left);
                    if (node.right != null) newStack.push(node.right);
                }
                stack = newStack;
                result.add(max);
            }
        }
        return result;
    }
}
