// Importance:xx
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int h = matrix.length;
        if (h == 0) return false;
        int w = matrix[0].length;
        if (w == 0) return false;
        int i = 0, j = w - 1;
        while (i < h && j >= 0) {
            int n = matrix[i][j];
            if (n == target) return true;
            if (n > target) j--;
            if (n < target) i++;
        }
        return false;
    }
}
