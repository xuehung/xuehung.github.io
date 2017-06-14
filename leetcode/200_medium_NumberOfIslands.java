public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[i].length ; j++) {
                if (fill(grid, i, j)) count++;
            }
        }
        return count;
    }

    private boolean fill(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length) return false;
        if (j < 0 || j >= grid[0].length) return false;
        if (grid[i][j] == '0') return false; 
        grid[i][j] = '0';
        fill(grid, i + 1, j);
        fill(grid, i - 1, j);
        fill(grid, i, j + 1);
        fill(grid, i, j - 1);
        return true;
    }
}
