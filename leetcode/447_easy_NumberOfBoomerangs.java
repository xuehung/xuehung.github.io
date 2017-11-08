class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        for (int i = 0 ; i < points.length ; i++) {
            Map<Long, Integer> distanceCount = new HashMap<>(); 
            for (int j = 0 ; j < points.length ; j++) {
                if (i != j) {
                    int x = points[i][0] - points[j][0];
                    int y = points[i][1] - points[j][1];
                    long distance = x * x + y * y;
                    distanceCount.put(distance, distanceCount.getOrDefault(distance, 0) + 1);
                }
            }
            for (Map.Entry<Long, Integer> e : distanceCount.entrySet()) {
                int n = e.getValue();
                count += (n * (n - 1));
            }
        }
        return count;
    }
}
