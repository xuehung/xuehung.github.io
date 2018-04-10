class Solution {
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        int w = board[0].length;
        boolean[][] isVisited = new boolean[h][w];
        for (int i = 0 ; i < h ; i++) {
            for (int j = 0 ; j < w ; j++) {
                if (_dfs(board, h, w, i, j, isVisited, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean _dfs(char[][] board, int h, int w, int i, int j, boolean[][] isVisited, String word, int idx) {
        if (i < 0 || i >= h || j < 0 || j >= w) return false;
        if (isVisited[i][j]) return false;
        if (word.charAt(idx) != board[i][j]) return false;
        if (idx == word.length() - 1) return true;
        isVisited[i][j] = true;
        idx++;
        boolean ret = _dfs(board, h, w, i - 1, j, isVisited, word, idx) ||
            _dfs(board, h, w, i + 1, j, isVisited, word, idx) ||
            _dfs(board, h, w, i, j - 1, isVisited, word, idx) ||
            _dfs(board, h, w, i, j + 1, isVisited, word, idx);
        isVisited[i][j] = false;
        return ret;
    }
}
