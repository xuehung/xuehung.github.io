class Solution {
    Integer prevVal = null;
    int count = 0;
    int answerCount = 0;
    List<Integer> answer = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        bfs(root);
        if (prevVal != null) checkResult(prevVal);
        int[] output = new int[answer.size()];
        int i = 0;
        for (int n : answer) {
            output[i++] = n;
        }
        return output;
    }
    private void bfs(TreeNode root) {
        if (root == null) return;
        bfs(root.left);
        int val = root.val;
        if (prevVal == null || prevVal == val) {
            count++;
        } else {
            checkResult(prevVal);
            count = 1;
        }
        prevVal = val;
        bfs(root.right);
    }

    private void checkResult(int val) {
        if (count == answerCount) {
            answer.add(val);
        } else if (count > answerCount) {
            answer.clear();
            answer.add(val);
            answerCount = count;
        }
    }
}
