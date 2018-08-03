class Solution {
    public int[][] imageSmoother(int[][] M) {
        int h = M.length;
        if (h == 0) return M;
        int w = M[0].length;
        int[][] output = new int[h][w];
        for (int i = 0 ; i < h ; i++) {
            for (int j = 0 ; j < w ; j++) {
                int sum = 0;
                int count = 0;
                for (int m = -1 ; m <= 1 ; m++) {
                    for (int n = -1 ; n <= 1 ; n++) {
                        int x = i + m, y = j + n;
                        if (x >= 0 && x < h && y >= 0 && y < w) {
                            sum += M[x][y];
                            count++;
                        }
                    }
                }
                output[i][j] = sum / count;
            } 
        }
        return output;
    }
}
