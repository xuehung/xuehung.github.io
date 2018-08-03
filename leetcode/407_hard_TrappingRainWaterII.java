// Importance:xxxxxx
// Google
class Solution {
    class Cell {
        int x;
        int y;
        int h;
        Cell(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
    int[] dirx = new int[] {0, 0, 1, -1};
    int[] diry = new int[] {1, -1, 0, 0};
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) return 0;
        int h = heightMap.length, w = heightMap[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.h - b.h);
        boolean[][] visited = new boolean[h][w];
        for (int i = 0 ; i < h ; i++) {
            pq.add(new Cell(i, 0, heightMap[i][0]));
            pq.add(new Cell(i, w - 1, heightMap[i][w - 1]));
            visited[i][0] = true;
            visited[i][w - 1] = true;
        }
        for (int i = 1 ; i < w - 1; i++) {
            pq.add(new Cell(0, i, heightMap[0][i]));
            pq.add(new Cell(h - 1, i, heightMap[h - 1][i]));
            visited[0][i] = true;
            visited[h - 1][i] = true;
        }
        int water = 0;
        while (!pq.isEmpty()) {
            Cell c = pq.poll();
            for (int i = 0 ; i < 4 ; i++) {
                int x = dirx[i] + c.x;
                int y = diry[i] + c.y;
                if (x >= 0 && x < h && y >= 0 && y < w) {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        pq.add(new Cell(x, y, Math.max(c.h, heightMap[x][y])));
                        water += (Math.max(0, c.h - heightMap[x][y]));
                    }
                }
            }
        }
        return water;
    }
}
