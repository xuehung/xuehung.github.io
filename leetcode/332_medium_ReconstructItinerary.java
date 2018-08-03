// Importance:xxxxxx
// Google
public List<String> findItinerary(String[][] tickets) {
    for (String[] ticket : tickets)
        targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
    visit("JFK");
    return route;
}

Map<String, PriorityQueue<String>> targets = new HashMap<>();
List<String> route = new LinkedList();

void visit(String airport) {
    while(targets.containsKey(airport) && !targets.get(airport).isEmpty())
        visit(targets.get(airport).poll());
    route.add(0, airport);
}
class Solution {
    class Edge {
        String next;
        boolean visited;
        public Edge(String next) {this.next = next;}
    }
    Map<String, List<Edge>> edges = new TreeMap<>();
    public List<String> findItinerary(String[][] tickets) {
        for (String[] t : tickets) {
            String from = t[0];
            String to = t[1];
            if (!edges.containsKey(from)) edges.put(from, new ArrayList<>());
            edges.get(from).add(new Edge(to));
        }
        for (String key : edges.keySet()) {
            Collections.sort(edges.get(key), (a, b) -> a.next.compareTo(b.next));
        }
        List<String> paths = new ArrayList<>();
        dfs("JFK", paths, tickets.length + 1);
        return paths;
    }

    private boolean dfs(String node, List<String> paths, int n) {
        paths.add(node);
        if (paths.size() == n) return true;
        if (edges.containsKey(node)) {
            for (Edge e : edges.get(node)) {
                if (!e.visited) {
                    e.visited = true;
                    if (dfs(e.next, paths, n)) return true;
                    e.visited = false;
                }
            }
        }
        paths.remove(paths.size() - 1);
        return false;
    }

}
