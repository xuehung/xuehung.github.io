// Importance:xxx
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<Integer> leaves = new ArrayList<>();
        HashMap<Integer, Set<Integer>> edgeMap = new HashMap<>();
        for (int i = 0 ; i < n ; i++) edgeMap.put(i, new HashSet<>());
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            edgeMap.get(a).add(b);
            edgeMap.get(b).add(a);
        }
        for (int i = 0 ; i < n ; i++) {
            if (edgeMap.get(i).size() == 1) leaves.add(i);
        }
        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int next = edgeMap.get(i).iterator().next();
                edgeMap.get(next).remove(i);
                if (edgeMap.get(next).size() == 1) newLeaves.add(next);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
