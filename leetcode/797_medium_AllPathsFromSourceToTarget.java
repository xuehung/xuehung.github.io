class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        for (int next : graph[0]) {
            path.add(next);
            _helper(graph, next, output, path);
            path.remove(path.size() - 1);
        }
        return output;
    }

    private void _helper(int[][] graph, int n, List<List<Integer>> output, List<Integer> path) {
        if (n == graph.length - 1) {
            output.add(new ArrayList<>(path));
        } else {
            for (int next : graph[n]) {
                path.add(next);
                _helper(graph, next, output, path);
                path.remove(path.size() - 1);
            }
        }
    }

}
