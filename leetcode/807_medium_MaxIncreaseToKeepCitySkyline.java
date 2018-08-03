class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int h = grid.length;
        if (h == 0) return 0;
        int w = grid[0].length;
        int[] rowMax = new int[h];
        int[] colMax = new int[w];
        for (int i = 0 ; i < h ; i++) {
            int max = -1;
            for (int j = 0 ; j < w ; j++) max = Math.max(max, grid[i][j]);
            rowMax[i] = max;
        }
        for (int j = 0 ; j < w ; j++) {
            int max = -1;
            for (int i = 0 ; i < h ; i++) max = Math.max(max, grid[i][j]);
            colMax[j] = max;
        }
        int sum = 0;
        for (int i = 0 ; i < h ; i++) {
            for (int j = 0 ; j < w ; j++) {
                int increase = Math.min(rowMax[i], colMax[j]) - grid[i][j];
                sum += increase;
            }
        }
        return sum;
    }
}
