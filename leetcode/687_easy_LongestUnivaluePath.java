class Solution {
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int max = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        return Math.max(max, helper(root.left, root.val) + helper(root.right, root.val));
    }

    private int helper(TreeNode root, int val) {
        if (root == null || root.val != val) return 0;
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        return 1 + Math.max(left, right);
    }
}
