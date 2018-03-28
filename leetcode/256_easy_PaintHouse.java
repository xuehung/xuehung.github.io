class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;
        for (int i = 1 ; i < n ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0 ; k < 3 ; k++) {
                    if (k != j) {
                        min = Math.min(min, costs[i][j] + costs[i - 1][k]);
                    }
                }
                costs[i][j] = min;
            }
        }
        return Math.min(costs[n - 1][0], Math.min(costs[n - 1][1], costs[n - 1][2]));
    }
}
