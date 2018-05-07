class Solution {
    public int findCircleNum(int[][] M) {
        int c = 0;
        boolean[] visited = new boolean[M.length];
        for (int i = 0 ; i < M.length ; i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                c++;
            }
        }
        return c;
    }

    private void dfs(int[][] M, int st, boolean[] visited) {
        for (int i = 0 ; i < M.length ; i++) {
            if (i != st && M[i][st] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(M, i, visited);
            }
        }
    }
}
