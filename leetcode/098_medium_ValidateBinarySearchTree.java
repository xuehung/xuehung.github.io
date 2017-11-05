// Importance: xx
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;
        long val = root.val;
        if (val < min || val > max) return false;
        return isValidBST(root.left, min, val - 1) && isValidBST(root.right, val + 1, max);
    }
}
