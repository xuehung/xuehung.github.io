// Impprtance: xxxx
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || stack.size() != 0) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                if (curr != null) {
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) continue;
            if (visited.contains(node)) {
                visited.remove(node);
                out.add(node.val);
            } else {
                stack.push(node.right);
                stack.push(node);
                stack.push(node.left);
                visited.add(node);
            }   
        }
        return out;
    }
}
