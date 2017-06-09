public class Solution {
    int ans = 0;
    int dpt = -1;
    public int findBottomLeftValue(TreeNode root) {
        ans = 0;
        dpt = -1;
        dfs(root, 0);
        return ans;
    }
    private void dfs(TreeNode root, int d) {
        if (root == null) return;
        if (d > dpt) {
            ans = root.val;
            dpt = d;
        }
        d++;
        dfs(root.left, d);
        dfs(root.right, d);
    }
}
