public class Solution {
    int pathLen;
    public int diameterOfBinaryTree(TreeNode root) {
        pathLen = 0;
        dfsHelper(root);
        return pathLen;
    }
    private int dfsHelper(TreeNode root) {
        if (root == null) return 0;
        int leftLen = dfsHelper(root.left);
        int rightLen = dfsHelper(root.right);
        pathLen = Math.max(pathLen, leftLen + rightLen);
        return Math.max(leftLen, rightLen) + 1;
    }
}
