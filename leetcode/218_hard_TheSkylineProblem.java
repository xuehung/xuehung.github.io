// Importance:xxxxx
// Google
class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        if (buildings.length == 0) return result;
        List<int[]> list = new ArrayList<>();
        for (int[] b : buildings) {
            list.add(new int[] {b[0], b[2]});
            list.add(new int[] {-b[1], b[2]});
        }
        Collections.sort(list, (a, b) -> Math.abs(a[0]) - Math.abs(b[0]));
        Integer prevLoc = null;
        Integer prevH = null;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] p : list) {
            int loc = Math.abs(p[0]);
            int h = p[1];
            if (prevLoc == null) prevLoc = loc;
            if (prevLoc != loc) {
                int newH = getMin(map);
                if (prevH == null || prevH != newH) result.add(new int[] {Math.abs(prevLoc), newH});
                prevH = newH;
                prevLoc = Math.abs(loc);
            }
            map.put(-h, map.getOrDefault(-h, 0) + (p[0] < 0 ? -1 : 1));
            if (map.get(-h) == 0) map.remove(-h);
        }
        int newH = getMin(map);
        if (prevH != newH) result.add(new int[] {Math.abs(prevLoc), newH});
        return result;
    }

    private int getMin(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            return -entry.getKey();
        }
        return 0;
    }
}
