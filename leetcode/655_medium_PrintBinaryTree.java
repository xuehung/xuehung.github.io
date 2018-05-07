class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int h = _getHeight(root);
        int w = (1 << h) - 1;
        List<List<String>> output = new ArrayList<>();
        for (int i = 0 ; i < h ; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0 ; j < w ; j++) {
                row.add("");
            }
            output.add(row);
        }
        _helper(root, 0, w / 2, output);

        return output;
    }

    private void _helper(TreeNode root, int row, int col, List<List<String>> output) {
        if (root == null) return;
        output.get(row).set(col, String.valueOf(root.val));
        int diff = 1 << (output.size() - row - 2);
        _helper(root.left, row + 1, col - diff, output);
        _helper(root.right, row + 1, col + diff, output);
    }

    private int _getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(_getHeight(root.left), _getHeight(root.right)) + 1;
    }
}
