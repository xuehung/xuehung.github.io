// Importance:x
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int pDiff = root.val - p.val;
        int qDiff = root.val - q.val;
        if (pDiff == 0 || qDiff == 0) return root;
        if (pDiff * qDiff < 0) return root;
        if (pDiff > 0 && qDiff > 0) return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
}
