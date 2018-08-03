class NumMatrix {

    int[][] dp;
    public NumMatrix(int[][] matrix) {
        int h = matrix.length;
        if (h == 0) return;
        int w = matrix[0].length;
        dp = new int[h][w];
        for (int i = 0 ; i < h ; i++) {
            for (int j = 0 ; j < w ; j++) {
                int sum = matrix[i][j];
                if (i - 1 >= 0) sum += dp[i - 1][j];
                if (j - 1 >= 0) sum += dp[i][j - 1];
                if (i - 1 >= 0 && j - 1 >= 0) sum -= dp[i - 1][j - 1];
                dp[i][j] = sum;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ret = dp[row2][col2];
        if (row1 - 1 >= 0) ret -= dp[row1 - 1][col2];
        if (col1 - 1 >= 0) ret -= dp[row2][col1 - 1];
        if (col1 - 1 >= 0 && row1 - 1 >= 0) ret += dp[row1 - 1][col1 -1];
        return ret;
    }
}
