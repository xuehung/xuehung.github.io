// Importance:xxxxx
// Google
class Solution {
    private final int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        int h = grid.length;
        if (h == 0) return 0;
        int w = grid[0].length;
        int[][] dp = new int[h][w];
        int[][] count = new int[h][w];
        int c = 0;
        for (int i = 0 ; i < h ; i++) {
            for (int j = 0 ; j < w ; j++) {
                if (grid[i][j] == 1) {
                    c++;
                    visit(grid, i, j, dp, new boolean[h][w], count);
                }
            }
        }
        int min = -1;
        for (int i = 0 ; i < h ; i++) {
            for (int j = 0 ; j < w ; j++) {
                if (grid[i][j] == 0 && count[i][j] == c) {
                    if (min < 0 || min > dp[i][j]) {
                        min = dp[i][j];
                    }
                }
            }
        }
        return min;
    }
    private void visit(int[][] grid, int i, int j, int[][] dp, boolean[][] visited, int[][] count) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j, 0});
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int[] d : dir) {
                int x = pos[0] + d[0], y = pos[1] + d[1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                    if (!visited[x][y] && grid[x][y] == 0) {
                        visited[x][y] = true;
                        dp[x][y] += (pos[2] + 1);
                        count[x][y]++;
                        q.add(new int[] {x, y, pos[2] + 1});
                    }
                }
            }
        }
    }
}
