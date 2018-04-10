class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Set<Integer> noIncomingEdge = new HashSet<>();
        int[] incomingCount = new int[numCourses];
        int[] result = new int[numCourses];
        boolean[][] adjacent = new boolean[numCourses][numCourses];
        int count = 0;
        for (int i = 0 ; i < numCourses ; i++ ) noIncomingEdge.add(i);
        for (int[] edge : prerequisites) {
            incomingCount[edge[0]]++;
            noIncomingEdge.remove(edge[0]);
            adjacent[edge[1]][edge[0]] = true;
        }
        while (!noIncomingEdge.isEmpty()) {
            int from = noIncomingEdge.iterator().next();
            result[count++] = from;
            for (int to = 0 ; to < numCourses ; to++) {
                if (to != from && adjacent[from][to]) {
                    incomingCount[to]--;
                    if (incomingCount[to] == 0) {
                        noIncomingEdge.add(to);
                    }
                } 
            }
            noIncomingEdge.remove(from);
        }
        return count == numCourses ? result : new int[0];
    }
}
