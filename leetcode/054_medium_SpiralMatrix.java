// Google
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return result;
        int h = matrix.length, w = matrix[0].length;
        int i = 0, j = 0;
        while (h > 0 && w > 0) {
            helper(matrix, i++, j++, h, w, result);
            h -= 2;
            w -= 2;
        }
        return result;
    }

    private void helper(int[][] matrix, int x, int y, int h, int w, List<Integer> result) {
        if (w == 1) {
            for (int i = x ; i < x + h ; i++) result.add(matrix[i][y]);
        } else if (h == 1) {
            for (int j = y ; j < y + w ; j++) result.add(matrix[x][j]);
        } else {
            for (int j = y ; j < y + w ; j++) result.add(matrix[x][j]);
            for (int i = x + 1 ; i < x + h - 1 ; i++) result.add(matrix[i][y + w - 1]);
            for (int j = y + w - 1 ; j >= y ; j--) result.add(matrix[x + h - 1][j]);
            for (int i = x + h - 2 ; i > x ; i--) result.add(matrix[i][y]);
        }
    }
}
