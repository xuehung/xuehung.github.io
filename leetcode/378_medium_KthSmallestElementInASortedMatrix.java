// Importance:xxxx
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int h = matrix.length;
        int w = matrix[0].length;
        int lo = matrix[0][0], hi = matrix[h - 1][w - 1];
        while (lo < hi) {
            int middle = lo + (hi - lo) / 2;
            int count = 0;
            int j = w - 1;
            for (int i = 0 ; i < h && j >= 0 ; i++) {
                while (j >= 0 && matrix[i][j] > middle) j--;
                count += (j + 1);
            }
            if (count >= k) hi = middle;
            else lo = middle + 1;
        }
        return lo;
    }
}
