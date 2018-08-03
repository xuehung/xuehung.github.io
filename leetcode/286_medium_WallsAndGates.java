// Importance:x
// Google
class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0 ; i < rooms.length ; i++) {
            for (int j = 0 ; j < rooms[0].length ; j++) {
                if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int dis) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) return;
        if (rooms[i][j] == -1) return;
        if (dis != 0 && rooms[i][j] <= dis) return;
        rooms[i][j] = dis;
        dis++;
        dfs(rooms, i + 1, j, dis);
        dfs(rooms, i, j + 1, dis);
        dfs(rooms, i - 1, j, dis);
        dfs(rooms, i, j - 1, dis);
    }
}
