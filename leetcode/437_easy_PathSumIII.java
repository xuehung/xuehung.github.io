// Importance:xxxxx
class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        return _helper(root, 0, sum, prefixSum);
    }

    private int _helper(TreeNode root, int pathSum, int target, Map<Integer, Integer> prefixSum) {
        if (root == null) return 0;
        int count = 0;
        pathSum += root.val;
        if (prefixSum.containsKey(pathSum - target)) {
            count += prefixSum.get(pathSum - target);
        }
        prefixSum.put(pathSum, prefixSum.getOrDefault(pathSum, 0) + 1);
        count += _helper(root.left, pathSum, target, prefixSum);
        count += _helper(root.right, pathSum, target, prefixSum);
        prefixSum.put(pathSum, prefixSum.get(pathSum) - 1);
        return count;
    }
}
