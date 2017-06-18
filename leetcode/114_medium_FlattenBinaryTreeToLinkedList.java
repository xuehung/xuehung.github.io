public class Solution {
    public void flatten(TreeNode root) {
        flattenHelper(root);
    }
    public TreeNode flattenHelper(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode flatLeftTail = flattenHelper(root.left);
        TreeNode flatRightTail = flattenHelper(root.right);
        TreeNode rightNode = root.right;
        root.right = root.left;
        root.left = null;
        if (flatLeftTail == null) {
            root.right = rightNode;
            return flatRightTail;
        } else if (flatRightTail == null) {
            return flatLeftTail;
        } else {
            flatLeftTail.right = rightNode;
            return flatRightTail;
        }
    }
}
