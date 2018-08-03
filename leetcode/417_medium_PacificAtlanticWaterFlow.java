class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        int h = matrix.length;
        if (h == 0) return result;
        int w = matrix[0].length;
        boolean[][] canFlow = new boolean[h][w];
        for (int i = 0 ; i < w ; i++) {
            dfs(matrix, 0, i, Integer.MIN_VALUE, new HashSet<>(), (x, y) -> {
                canFlow[x][y] = true;
            });
        }
        for (int i = 1 ; i < h ; i++) {
            dfs(matrix, i, 0, Integer.MIN_VALUE, new HashSet<>(), (x, y) -> {
                canFlow[x][y] = true;
            });
        }
        for (int i = 0 ; i < w ; i++) {
            dfs(matrix, h - 1, i, Integer.MIN_VALUE, new HashSet<>(), (x, y) -> {
                if (canFlow[x][y]) result.add(new int[] {x, y});
                canFlow[x][y] = false;
            });
        }
        for (int i = 0 ; i < h - 1 ; i++) {
            dfs(matrix, i, w - 1, Integer.MIN_VALUE, new HashSet<>(), (x, y) -> {
                if (canFlow[x][y]) result.add(new int[] {x, y});
                canFlow[x][y] = false;
            });
        }
        return result;
    }

    private void dfs(int[][] matrix, int i, int j, int fromH, Set<String> visited, BiConsumer<Integer, Integer> c) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return;
        if (matrix[i][j] < fromH) return;
        String key = i + ":" + j;
        if (visited.contains(key)) return;
        visited.add(key);
        c.accept(i, j);
        dfs(matrix, i + 1, j, matrix[i][j], visited, c);
        dfs(matrix, i - 1, j, matrix[i][j], visited, c);
        dfs(matrix, i, j + 1, matrix[i][j], visited, c);
        dfs(matrix, i, j - 1, matrix[i][j], visited, c);
    }
}
