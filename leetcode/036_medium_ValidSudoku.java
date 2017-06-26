public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[] used = new boolean[9];
        for (int i = 0 ; i < 9 ; i++) {
            clear(used);
            for (int j = 0 ; j < 9 ; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (used[c - '1']) return false;
                    used[c - '1'] = true;
                }
            }
            clear(used);
            for (int j = 0 ; j < 9 ; j++) {
                char c = board[j][i];
                if (c != '.') {
                    if (used[c - '1']) return false;
                    used[c - '1'] = true;
                }
            }
            clear(used);
            int x = (i / 3) * 3;
            int y = (i % 3) * 3;
            for (int m = 0 ; m < 3 ; m++) {
                for (int n = 0 ; n < 3 ; n++) {
                    char c = board[x + m][y + n];
                    if (c != '.') {
                        if (used[c - '1']) {
                            return false;
                        }
                        used[c - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
    private void clear(boolean[] used) {
        for (int i = 0 ; i < used.length ; i++) used[i] = false;
    }
}
