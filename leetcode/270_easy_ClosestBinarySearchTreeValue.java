// Google
class Solution {
    public int closestValue(TreeNode root, double target) {
        int val = root.val;
        TreeNode next = val > target ? root.left : root.right;

        if (next == null) return val;
        int nextVal = closestValue(next, target);
        return Math.abs(target - nextVal) < Math.abs(target - val) ? nextVal : val;
    }
}
