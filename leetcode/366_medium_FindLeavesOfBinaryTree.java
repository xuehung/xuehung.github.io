class Solution {

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    private int helper(List<List<Integer>> result, TreeNode root) {
        if (root == null) return -1;
        int d = 1 + Math.max(helper(result, root.left), helper(result, root.right));
        if (result.size() <= d) result.add(new ArrayList<>());
        result.get(d).add(root.val);
        return d;
    }
}
