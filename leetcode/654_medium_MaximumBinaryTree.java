// Importance:xxxxx
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> decrease = new LinkedList<>();
        for (int n : nums) {
            TreeNode node = new TreeNode(n);
            while (!decrease.isEmpty() && decrease.peek().val < n) {
                node.left = decrease.pop();
            }
            if (!decrease.isEmpty()) {
                decrease.peek().right = node;
            }
            decrease.push(node);
        }

        return decrease.getLast();
    }
}
