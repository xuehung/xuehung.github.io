class TicTacToe {

    int[][] board;
    int n;

    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        board[row][col] = player;
        int ret = player;
        for (int i = 0 ; ret == player && i < n ; i++) {
            if (board[row][i] != player) ret = 0;
        }
        if (ret != 0) return ret;
        ret = player;
        for (int i = 0 ; ret == player && i < n ; i++) {
            if (board[i][col] != player) ret = 0;
        }
        if (ret != 0) return ret;
        if (col == row) {
            ret = player;
            for (int i = 0 ; ret == player && i < n ; i++) {
                if (board[i][i] != player) ret = 0;
            }
            if (ret != 0) return ret;
        }
        if (col + row == n - 1) {
            ret = player;
            for (int i = 0 ; ret == player && i < n ; i++) {
                if (board[i][n - 1 - i] != player) ret = 0;
            }
        }
        return ret;
    }
}
