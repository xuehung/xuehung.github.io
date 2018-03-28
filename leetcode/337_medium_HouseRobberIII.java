// Importance:x
class Solution {
    public int rob(TreeNode root) {
        int[] val = robHelper(root);
        return Math.max(val[0], val[1]);
    }

    public int[] robHelper(TreeNode root) {
        int[] val = new int[2];
        if (root == null) return val;
        int[] leftVal = robHelper(root.left);
        int[] rightVal = robHelper(root.right);
        val[0] = root.val + leftVal[1] + rightVal[1];
        val[1] = Math.max(leftVal[0], leftVal[1]) + Math.max(rightVal[0], rightVal[1]);
        return val;
    }
}
