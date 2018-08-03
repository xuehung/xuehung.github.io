// Google
class Solution {
    private static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int[][] updateMatrix(int[][] matrix) {
        int h = matrix.length;
        if (h == 0) return matrix;
        int w = matrix[0].length;
        int[][] output = new int[h][w];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0 ; i < h ; i++) {
            for (int j = 0 ; j < w ; j++) {
                if (matrix[i][j] != 0) output[i][j] = Integer.MAX_VALUE;
                else q.add(new int[] {i, j});
            }
        }
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int x = pos[0], y = pos[1];
            for (int[] d : dir) {
                int xx = x + d[0];
                int yy = y + d[1];
                if (xx >= 0 && yy >= 0 && xx < h && yy < w && output[xx][yy] > output[x][y] + 1) {
                    output[xx][yy] = output[x][y] + 1;
                    q.add(new int[]{xx, yy});
                }
            }
        }
        return output;
    }
}
