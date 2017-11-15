class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int h = board.length;
        int w = board[0].length;
        int[] preRow = new int[w];
        int preCell = 0;
        for (int i = 0 ; i < h ; i++) {
            int[] newPreRow = new int[w];
            for (int j = 0 ; j < w ; j++) {
                int sum = preCell + preRow[j];
                if (j > 0) sum += preRow[j - 1];
                if (j > 0 && i < h - 1) sum += board[i + 1][j - 1];
                if (i < h - 1) sum += board[i + 1][j];
                if (j < w - 1) sum = sum + preRow[j + 1] + board[i][j + 1];
                if (i < h - 1 && j < w - 1) sum += board[i + 1][j + 1];
                preCell = board[i][j];
                newPreRow[j] = preCell;
                if (board[i][j] == 1 && (sum < 2 || sum > 3)) board[i][j] = 0;
                else if (board[i][j] == 0 && sum == 3) board[i][j] = 1;
            }
            preRow = newPreRow;
            preCell = 0;
        }
    }
}
