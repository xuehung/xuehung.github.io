class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        int leftCount = count(root.left);
        if (leftCount >= k) return kthSmallest(root.left, k);
        else if (leftCount == k - 1) return root.val;
        else return kthSmallest(root.right, k - leftCount - 1);
    }

    private int count(TreeNode root) {
        if (root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }
}
