// Importance:xxx
public class Solution {
    Map<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        UndirectedGraphNode copy = mapping.get(node);
        if (copy != null) return copy;
        copy = new UndirectedGraphNode(node.label);
        mapping.put(node, copy);
        for (UndirectedGraphNode next : node.neighbors) {
            copy.neighbors.add(cloneGraph(next));
        }
        return copy;
    }
}
