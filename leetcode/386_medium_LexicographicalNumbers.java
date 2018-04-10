// Importance:xxx
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1 ; i < 10 ; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    private void dfs(int curr, int n, List<Integer> result) {
        if (curr > n) return;
        result.add(curr);
        curr *= 10;
        for (int i = 0 ; i < 10 ; i++) {
            if (curr + i <= n) dfs(curr + i, n, result);
            else break;
        }
    }
}
