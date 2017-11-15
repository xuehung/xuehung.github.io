class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxSquare = 0;
        int h = matrix.length;
        int w = matrix[0].length;
        int[][] dp = new int[h][w];
        for (int i = 0 ; i < h ; i++) {
            for (int j = 0 ; j < w ; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1;
                    for (int k = 1 ; i - k >= 0 && j - k >=0 ; k++) {
                        if (matrix[i - k][j] == '1' && matrix[i][j - k] == '1' && dp[i - 1][j - 1] >= k) {
                            dp[i][j]++;
                        } else {
                            break;
                        }
                    }
                    maxSquare = Math.max(maxSquare, dp[i][j]);
                }
            }
        }
        return maxSquare * maxSquare;
    }
}
