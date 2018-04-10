public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode ptr;
    int val;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        ptr = root;
    }

    public boolean hasNext() {
        while (ptr != null || !stack.isEmpty()) {
            if (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            } else {
                ptr = stack.pop();
                val = ptr.val;
                ptr = ptr.right;
                return true;
            }
        }
        return false;
    }

    public int next() {
        return val;
    }
}

