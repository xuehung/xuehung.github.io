class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int x = grid.length;
        if (x < 1) return perimeter;
        int y = grid[0].length;
        for (int i = 0 ; i < x ; i++) {
            for (int j = 0 ; j < y ; j++) {
                if (grid[i][j] == 1) {
                    if (i - 1 >= 0 && grid[i - 1][j] == 0) perimeter++;
                    if (i + 1 < x && grid[i + 1][j] == 0) perimeter++;
                    if (j - 1 >= 0 && grid[i][j - 1] == 0) perimeter++;
                    if (j + 1 < y && grid[i][j + 1] == 0) perimeter++;
                    if (i == 0) perimeter++;
                    if (i == x - 1) perimeter++;
                    if (j == 0) perimeter++;
                    if (j == y - 1) perimeter++;
                }
            }
        }
        return perimeter;
    }
}
