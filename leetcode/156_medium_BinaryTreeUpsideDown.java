class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return root;
        return helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        } else {
            TreeNode newRoot = helper(root.left);
            root.left.left = root.right;
            root.left.right = root;
            root.left = null;
            root.right = null;
            return newRoot;
        }
    }
}
