// Importance:xxx
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] matrix = new boolean[numCourses][numCourses];
        int[] fromCount = new int[numCourses];
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> noFrom = new Stack<>();
        for (int[] edge : prerequisites) {
            int from = edge[0];
            int to = edge[1];
            matrix[from][to] = true;
            fromCount[to]++;
        }
        for (int i = 0 ; i < numCourses ; i++) {
            if (fromCount[i] == 0) noFrom.add(i);
        }
        while (!noFrom.isEmpty()) {
            int from = noFrom.pop();
            visited.add(from);
            for (int to= 0 ; to < numCourses ; to++) {
                if (matrix[from][to]) {
                    fromCount[to]--;
                    if (fromCount[to] == 0) noFrom.add(to);
                }
            }
        }
        return visited.size() == numCourses;
    }
}
