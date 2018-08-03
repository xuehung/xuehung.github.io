// Google
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Set<String> nodes = new HashSet<>();
        Map<String, Map<String, Double>> paths = new HashMap<>();
        for (int i = 0 ; i < equations.length ; i++) {
            String[] eq = equations[i];
            nodes.add(eq[0]);
            nodes.add(eq[1]);
            paths.computeIfAbsent(eq[0], k -> new HashMap<>()).put(eq[1], values[i]);
            paths.computeIfAbsent(eq[1], k -> new HashMap<>()).put(eq[0], 1 / values[i]);
        }
        double[] output = new double[queries.length];
        for (int i = 0 ; i < output.length ; i++) {
            Double d = dfs(queries[i][0], queries[i][1], nodes, paths, new HashSet<>());
            output[i] = d == null ? -1.0 : d;
        }
        return output;
    }

    private Double dfs(String a, String b, Set<String> nodes, Map<String, Map<String, Double>> paths, Set<String> visited) {
        if (a.equals(b)) {
            return nodes.contains(a) ? 1.0 : -1.0;
        }
        Map<String, Double> next = paths.get(a);
        if (next != null) {
            for (Map.Entry<String, Double> e : next.entrySet()) {
                String to = e.getKey();
                if (!visited.contains(to)) {
                    visited.add(to);
                    Double d = dfs(to, b, nodes, paths, visited);
                    if (d != null) {
                        return d * e.getValue();
                    }
                    visited.remove(to);
                }
            }
        }
        return null;
    }

}
