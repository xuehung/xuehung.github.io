class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) stack.add(root);
        while (!stack.isEmpty()) {
            Stack<TreeNode> newStack = new Stack<>();
            List<Integer> row = new ArrayList<>();
            for (TreeNode tn : stack) {
                if (tn.left != null) newStack.add(tn.left);
                if (tn.right != null) newStack.add(tn.right);
                row.add(tn.val);
            }
            result.add(row);
            stack = newStack;
        }
        return result;
    }
}
