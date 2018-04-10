class Solution {
    public int countBattleships(char[][] board) {
        int h = board.length;
        int w = board[0].length;
        int count = 0;
        for (int i = 0 ; i < h ; i++) {
            for (int j = 0 ; j < w ; j++) {
                if (board[i][j] == 'X' && isHead(board, h, w, i, j)) count++;
            }
        }
        return count;
    }
    private boolean isHead(char[][] board, int h, int w, int i, int j) {
        boolean isLeftEmpty = j == 0 || board[i][j - 1] == '.';
        boolean isRightEmpty = j == w - 1 || board[i][j + 1] == '.';
        boolean isUpEmpty = i == 0 || board[i - 1][j] == '.';
        boolean isDownEmpty = i == h - 1 || board[i + 1][j] == '.';
        if (isLeftEmpty && isUpEmpty && isDownEmpty) return true;
        if (isLeftEmpty && isUpEmpty && isRightEmpty) return true;
        return false;
    }
}
