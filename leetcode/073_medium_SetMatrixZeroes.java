// Importance: x
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        for (int i = 0 ; i < matrix.length ; i++) {
            boolean rowZero = false;
            for (int j = 0 ; j < matrix[i].length ; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0; // this column should be zero
                    rowZero = true;
                }
            }
            if (i == 0) firstRowZero = rowZero;
            else if (rowZero) {
                for (int j = 0 ; j < matrix[i].length ; j++) matrix[i][j] = 0;
            }
        }
        for (int i = 1 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[i].length ; j++) {
                if (matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if (firstRowZero) {
            for (int j = 0 ; j < matrix[0].length ; j++) matrix[0][j] = 0;
        }
    }
}
