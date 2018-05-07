class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> sum = new ArrayList<>();
        _helper(root, 0, count, sum);
        for (int i = 0 ; i < sum.size() ; i++) {
            sum.set(i, sum.get(i) / count.get(i));
        }
        return sum;
    }

    private void _helper(TreeNode root, int level, List<Integer> count, List<Double> sum) {
        if (root == null) return;
        if (count.size() <= level) {
            count.add(0);
            sum.add(0.0);
        }
        count.set(level, count.get(level) + 1);
        sum.set(level, sum.get(level) + root.val);
        _helper(root.left, level + 1, count, sum);
        _helper(root.right, level + 1, count, sum);
    }
}
