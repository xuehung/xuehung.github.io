// Importance:xxx
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = B.length;
        int k = n > 0 ? B[0].length : 0;
        int[][] C = new int[m][k];
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                if (A[i][j] != 0) {
                    for (int p = 0 ; p < k ; p++) {
                        C[i][p] += A[i][j] * B[j][p];
                    }
                }
            }
        }
        return C;
    }
}

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = B.length;
        int k = n > 0 ? B[0].length : 0;
        int[][] C = new int[m][k];
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < k ; j++) {
                for (int x = 0 ; x < n ; x++) {
                    if (A[i][x] != 0 && B[x][j] != 0) C[i][j] += A[i][x] * B[x][j];
                }
            }
        }
        return C;
    }
}
