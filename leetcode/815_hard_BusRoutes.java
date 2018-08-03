// Importance:xxxxx
// Google
class Solution {
    Map<Integer, Set<Integer>> stopToRoute;
    Set<Integer> visited;
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        stopToRoute = new HashMap<>();
        visited = new HashSet<>();
        for (int i = 0 ; i < routes.length ; i++) {
            for (int stop : routes[i]) {
                stopToRoute.computeIfAbsent(stop, k -> new HashSet<>()).add(i);
            }
        }
        Set<Integer> q = new HashSet<>();
        if (stopToRoute.containsKey(S)) {
            for (int rid : stopToRoute.get(S)) {
                for (int stop : routes[rid]) {
                    q.add(stop);
                }
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            ans++;
            Set<Integer> nq = new HashSet<>();
            for (int stop : q) {
                if (stop == T) return ans;
                if (!visited.contains(stop)) {
                    visited.add(stop);
                    for (int rid : stopToRoute.get(stop)) {
                        for (int next : routes[rid]) {
                            if (!visited.contains(next)) {
                                nq.add(next);
                            }
                        }
                    }
                }
                q = nq;
            }
        }
        return -1;
    }
}
