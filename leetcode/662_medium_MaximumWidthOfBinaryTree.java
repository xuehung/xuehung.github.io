class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();
        dfs(root, 0, 0, min, max);
        int maxW = 0;
        for (int i = 0 ; i < min.size() ; i++) {
            maxW = Math.max(maxW, max.get(i) - min.get(i));
        }
        return maxW + 1;
    }

    private void dfs(TreeNode root, int d, int val, List<Integer> min, List<Integer> max) {
        if (root == null) return;
        if (min.size() <= d) min.add(val);
        if (max.size() <= d) max.add(val);
        else max.set(d, val);
        d++;
        val = val << 1;
        dfs(root.left, d, val, min, max);
        dfs(root.right, d, val + 1, min, max);
    }
}
