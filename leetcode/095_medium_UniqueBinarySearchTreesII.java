class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return (new ArrayList<TreeNode>());
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> trees = new ArrayList<>();
        if (left > right) {
            trees.add(null);
        } else if (left == right) {
            trees.add(new TreeNode(left));
        } else {
            for (int i = left ; i <= right ; i++) {
                List<TreeNode> leftTrees = generateTrees(left, i - 1);
                List<TreeNode> rightTrees = generateTrees(i + 1, right);
                for (TreeNode leftNode : leftTrees) {
                    for (TreeNode rightNode : rightTrees) {
                        TreeNode root = new TreeNode(i);
                        root.left = leftNode;
                        root.right = rightNode;
                        trees.add(root);
                    }
                }
            }
        }
        return trees;
    }
}
