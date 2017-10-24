public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }
    public TreeNode sortedArrayToBSTHelper(int[] nums, int begin, int end) {
        if (begin > end) return null;
        if (begin == end) {
            return new TreeNode(nums[begin]);
        }
        int middle = (end - begin) / 2 + begin;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBSTHelper(nums, begin, middle - 1);
        root.right = sortedArrayToBSTHelper(nums, middle + 1, end);
        return root;
    }
}
