class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            List<TreeNode> newList = new ArrayList<>();
            for (TreeNode node : list) {
                if (node != null) {
                    row.add(node.val);
                    newList.add(node.left);
                    newList.add(node.right);
                }
            }
            if (!row.isEmpty()) result.add(0, row);
            list = newList;
        }
        return result;
    }
}
