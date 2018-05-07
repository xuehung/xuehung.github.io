class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int h = nums.length;
        if (h == 0) return nums;
        int w = nums[0].length;
        if (r * c != h * w) return nums;
        if (h == r && w == c) return nums;
        int[][] output = new int[r][c];
        int count = 0;
        for (int i = 0 ; i < h ; i++) {
            for (int j = 0 ; j < w ; j++) {
                int x = count / c;
                int y = count % c;
                output[x][y] = nums[i][j];
                count++;
            }
        }
        return output;
    }
}
