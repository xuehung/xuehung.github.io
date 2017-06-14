public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        dfsHelper(view, root, 1);
        return view;
    }

    private void dfsHelper(List<Integer> view, TreeNode root, int d) {
        if (root == null) return;
        if (view.size() < d) {
            view.add(root.val);
        } else {
            view.set(d - 1, root.val);
        }
        dfsHelper(view, root.left, d + 1);
        dfsHelper(view, root.right, d + 1);
    }
}
