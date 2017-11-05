class Solution {
    Integer prev = null;
    int answer = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        bfs(root);
        return answer;
    }

    private void bfs(TreeNode root) {
        if (root == null) return;
        bfs(root.left);
        if (prev != null) answer = Math.min(answer, root.val - prev);
        prev = root.val;
        bfs(root.right);
    }
}
