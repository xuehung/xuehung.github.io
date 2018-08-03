// Google
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int h = matrix.length;
        if (h == 0) return new int[]{};
        int w = matrix[0].length;
        int[] output = new int[h * w];
        int ptr = 0;
        int i = 0, j = 0;
        Stack<Integer> stack = new Stack<>();
        boolean reserve = false;
        while (j < w) {
            int x = i, y = j;
            while (x >= 0 && y < w) {
                if (reserve) {
                    stack.push(matrix[x][y]);
                } else {
                    output[ptr++] = matrix[x][y];
                }
                x--;
                y++;
            }
            if (reserve) {
                while (!stack.isEmpty()) output[ptr++] = stack.pop();
            }
            if (i == h - 1) {
                j++;
            } else {
                i++;
            }
            reserve = !reserve;
        }
        return output;
    }
}
