class Solution {
    int max;
    public int maxAreaOfIsland(int[][] grid) {
        max = 0;
        int h = grid.length;
        if (h == 0) return max;
        int w = grid[0].length;
        for (int i = 0 ; i < h ; i++) {
            for (int j = 0 ; j < w ; j++) {
                max = Math.max(max, helper(grid, i, j, new boolean[h][w]));
            }
        }
        return max;
    }

    private int helper(int[][] grid, int x , int y, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return 0;
        if (grid[x][y] == 0) return 0;
        if (visited[x][y]) return 0;
        visited[x][y] = true;
        return 1 + helper(grid, x - 1, y, visited)
            + helper(grid, x + 1, y, visited)
            + helper(grid, x, y - 1, visited)
            + helper(grid, x, y + 1, visited);
    }
}

