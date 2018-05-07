class Solution {
    int count;
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        isUnivalSubtree(root);
        return count;
    }

    private boolean isUnivalSubtree(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }
        boolean isLeft = isUnivalSubtree(root.left);
        boolean isRight = isUnivalSubtree(root.right);
        int val = root.val;
        if (isLeft && isRight) {
            if (val == root.left.val && val == root.right.val) {
                count++;
                return true;
            }
        } else if (isLeft || isRight) {
            if ((root.left == null || (isLeft && root.left.val == val)) && 
                    (root.right == null || (isRight && root.right.val == val))) {
                count++;
                return true;
                    }
        }
        return false;
    }
}
