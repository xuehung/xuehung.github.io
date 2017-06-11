public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        if (root != null) {
            dfs(root, stack, result);
        }
        return result;
    }
    public void dfs(TreeNode root, Stack<String> stack, List<String> result) {
        if (root == null) {
            return;
        } else {
            stack.push(String.valueOf(root.val));
            if (root.left == null && root.right == null) {
                result.add(String.join("->", stack));
            } else {
                dfs(root.left, stack, result);
                dfs(root.right, stack, result);    
            }
            stack.pop();
        }
    }
}
