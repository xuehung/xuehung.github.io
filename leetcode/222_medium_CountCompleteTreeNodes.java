// Importance: xx
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = 0;
        int rightDepth = 0;
        for (TreeNode ptr = root ; ptr != null ; ptr = ptr.left) leftDepth++;
        for (TreeNode ptr = root ; ptr != null ; ptr = ptr.right) rightDepth++;
        if (leftDepth == rightDepth) return (1 << leftDepth) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
