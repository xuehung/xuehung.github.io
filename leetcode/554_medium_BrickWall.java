// Importance: xx
public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> posToEdgeCount = new HashMap<>();
        int max = 0;
        for (List<Integer> row : wall) {
            int pos = 0;
            for (int i = 0 ; i < row.size() - 1 ; i++) {
                pos += row.get(i);
                posToEdgeCount.put(pos, posToEdgeCount.getOrDefault(pos, 0) + 1);
                max = Math.max(max, posToEdgeCount.get(pos));
            }
        }
        return wall.size() - max;
    }
}
