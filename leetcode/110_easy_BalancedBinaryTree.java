public class Solution {
    public boolean isBalanced(TreeNode root) {
        return _isBalanced(root) >= 0;
    }

    public int _isBalanced(TreeNode root) {
        if (root == null) return 0;
        int len1 = _isBalanced(root.left);
        int len2 = _isBalanced(root.right);
        if (len1 < 0 || len2 < 0) return -1;
        else if (Math.abs(len1 - len2) <= 1) return Math.max(len1, len2) + 1;
        else return -1;
    }
}
