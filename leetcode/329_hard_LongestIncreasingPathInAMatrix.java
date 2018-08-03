// Importance:xxxxx
public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

public int longestIncreasingPath(int[][] matrix) {
    if(matrix.length == 0) return 0;
    int m = matrix.length, n = matrix[0].length;
    int[][] cache = new int[m][n];
    int max = 1;
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            int len = dfs(matrix, i, j, m, n, cache);
            max = Math.max(max, len);
        }
    }   
    return max;
}

public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
    if(cache[i][j] != 0) return cache[i][j];
    int max = 1;
    for(int[] dir: dirs) {
        int x = i + dir[0], y = j + dir[1];
        if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
        int len = 1 + dfs(matrix, x, y, m, n, cache);
        max = Math.max(max, len);
    }
    cache[i][j] = max;
    return max;
}
class Solution {
    Integer[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        int h = matrix.length;
        if (h == 0) return max;
        int w = matrix[0].length;
        dp = new Integer[h][w];
        for (int i = 0 ; i < h ; i++) {
            for (int j = 0 ; j < w ; j++) {
                max = Math.max(max, dfs(matrix, i, j, (long)matrix[i][j] - 1));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, long prev) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return 0;
        }
        if (matrix[i][j] <= prev) return 0;
        if (dp[i][j] != null) return dp[i][j];
        int max = 0;
        max = Math.max(max, dfs(matrix, i + 1, j, matrix[i][j]));
        max = Math.max(max, dfs(matrix, i - 1, j, matrix[i][j]));
        max = Math.max(max, dfs(matrix, i, j + 1, matrix[i][j]));
        max = Math.max(max, dfs(matrix, i, j - 1, matrix[i][j]));
        dp[i][j] = max + 1;
        return dp[i][j];
    }
}
