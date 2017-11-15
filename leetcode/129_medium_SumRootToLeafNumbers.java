public class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        dfsHelper(root, 0);
        return sum;
    }
    private void dfsHelper(TreeNode root, int currentNum) {
        if (root == null) return;
        currentNum += root.val;
        if (root.left == null && root.right == null) {
            sum += currentNum;
        } else {
            currentNum *= 10;
            dfsHelper(root.left, currentNum);
            dfsHelper(root.right, currentNum);
        }
    }
}
