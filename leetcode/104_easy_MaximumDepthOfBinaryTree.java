class Solution {
    int answer = 0;
    public int maxDepth(TreeNode root) {
        answer = 0;
        helper(root, 0);
        return answer;
    }

    private void helper(TreeNode root, int d) {
        if (root == null) return;
        d++;
        answer = Math.max(answer, d);
        helper(root.left, d);
        helper(root.right, d);
    }
}
