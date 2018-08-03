// Importance:xxxxx
// Google
class Solution {
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        boolean equals(Point p) {
            return x == p.x && y == p.y;
        }
    }

    boolean[][] visited;
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int h = maze.length;
        int w = maze[0].length;
        visited = new boolean[h][w];
        return visit(maze, new Point(start[0], start[1]), new Point(destination[0], destination[1]));
    }

    private boolean visit(int[][] maze, Point s, Point e) {
        if (s.equals(e)) return true;
        if (visited[s.x][s.y]) return false;
        visited[s.x][s.y] = true;
        for (int i = 0 ; i < 4 ; i++) {
            Point next = getNextPoint(maze, s, i);
            if (!s.equals(next) && visit(maze, next, e)) return true;
        }
        return false;
    }

    private Point getNextPoint(int[][] maze, Point s, int d) {
        int nx = s.x;
        int ny = s.y;
        while (nx + dir[d][0] >= 0 && nx + dir[d][0] < maze.length 
                && ny + dir[d][1] >= 0 && ny + dir[d][1] < maze[0].length
                && maze[nx + dir[d][0]][ny + dir[d][1]] == 0) {
            nx += dir[d][0];
            ny += dir[d][1];
                }
        return new Point(nx, ny);
    }
}
