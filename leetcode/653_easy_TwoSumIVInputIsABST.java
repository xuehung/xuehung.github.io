
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return helper(root, k, new HashSet<>());
    }

    private boolean helper(TreeNode root, int k, Set<Integer> set) {
        if (root == null) return false;
        if (helper(root.left, k, set)) return true;
        int diff = k - root.val;
        if (diff <= root.val && set.contains(k - root.val)) return true;
        set.add(root.val);
        if (helper(root.right, k, set)) return true;
        return false;
    }
}
