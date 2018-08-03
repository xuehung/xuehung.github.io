// Importance:xxxxx
// Google
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) return true;
        if (edges.length != n - 1) return false;
        boolean[][] em = new boolean[n][n];
        for (int[] e : edges) {
            em[e[0]][e[1]] = true;
            em[e[1]][e[0]] = true;
        }
        boolean[] visited = new boolean[n];
        if (!dfs(-1, 0, visited, em)) return false;
        for (int i = 0 ; i < n ; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

    private boolean dfs(int prev, int k, boolean[] visited, boolean[][] em) {
        if (visited[k]) return false;
        visited[k] = true;
        for (int i = 0 ; i < em.length ; i++) {
            if (i != k && i != prev && em[k][i]) {
                if (!dfs(k, i, visited, em)) return false;
            }
        }
        return true;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] roots = new int[n];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }

        for (int[] e : edges) {
            int root1 = find(roots, e[0]);
            int root2 = find(roots, e[1]);

            if (root1 == root2) {
                return false;
            }
            else {
                roots[root1] = root2;
            }            
        }

        return edges.length == n - 1;
    }

    public int find(int[] roots, int index) {
        if (roots[index] != index) {
            roots[index] = find(roots, roots[index]);
        }

        return roots[index];
    }
}
