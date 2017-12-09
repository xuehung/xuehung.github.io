class Solution { 
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;
    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        travel(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void travel(TreeNode root) {
        if (root == null) return;
        travel(root.left);
        if (first == null && prev.val > root.val) first = prev;
        if (first != null && prev.val > root.val) second = root;
        prev = root;
        travel(root.right);
    }
}
