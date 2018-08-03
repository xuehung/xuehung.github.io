// Importance:xxx
// Google
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int h = matrix.length, w = matrix[0].length;
        int i = h - 1, j = 0;
        while (i < h && j < w) {
            int m = i, n = j;
            int val = matrix[i][j];
            while (m < h && n < w) {
                if (val != matrix[m][n]) return false;
                m++;
                n++;
            }
            if (i >= 1) {
                i--;
            } else {
                j++;
            }
        }
        return true;
    }
}
