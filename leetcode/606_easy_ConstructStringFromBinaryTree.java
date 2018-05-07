class Solution {
    StringBuilder sb;
    public String tree2str(TreeNode t) {
        sb = new StringBuilder();
        helper(t, sb);
        return sb.toString();
    }

    private void helper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) return;
        sb.append("(");
        helper(root.left, sb);
        sb.append(")");
        if (root.right != null) {
            sb.append("(");
            helper(root.right, sb);
            sb.append(")");
        }
    }
}
