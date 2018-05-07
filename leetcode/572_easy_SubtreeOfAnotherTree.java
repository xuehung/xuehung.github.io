class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        if (s.val == t.val && (_isSubtreeHelper(s.left, t.left) && _isSubtreeHelper(s.right, t.right))) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private boolean _isSubtreeHelper(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (t == null || s == null) return false;
        if (s.val != t.val) return false;
        return _isSubtreeHelper(s.left, t.left) && _isSubtreeHelper(s.right, t.right);
    }
}
