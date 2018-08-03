// Google
class Solution {
    int max = 0;
    public int longestConsecutive(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int len = 1;
        int left = helper(root.left);
        int right = helper(root.right);
        if (root.left != null && root.val == root.left.val - 1) {
            len = Math.max(len, left + 1);
        }
        if (root.right != null && root.val == root.right.val - 1) {
            len = Math.max(len, right + 1);
        }
        max = Math.max(max, len);
        return len;
    }
}
