// Importance:xx
class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> xPoints = new ArrayList<>();
        List<Integer> yPoints = new ArrayList<>();
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                if (grid[i][j] == 1) {
                    xPoints.add(i);
                    yPoints.add(j);
                }
            }
        }
        return getDistance(xPoints) + getDistance(yPoints);
    }

    private int getDistance(List<Integer> list) {
        Collections.sort(list);
        int left = 0, right = list.size() - 1;
        int dist = 0;
        while (left < right) {
            dist += (list.get(right--) - list.get(left++));
        }
        return dist;
    }
}

class Solution {
    public int minTotalDistance(int[][] grid) {
        int rlen = grid.length, clen = grid[0].length;
        int[] row = new int[rlen], col = new int[clen];
        for (int r=0; r<rlen; ++r)
            for (int c=0; c<clen; ++c)
                if (grid[r][c] == 1) {
                    ++row[r];
                    ++col[c];
                }
        int total = 0;
        for (int[] item : new int[][]{ row, col }) {
            int left = 0, right = item.length - 1;
            while (left < right) {
                int people = Math.min(item[left], item[right]);
                total += people * (right - left);  // people * distance
                if ((item[left] -= people) == 0) ++left;
                if ((item[right] -= people) == 0) --right;
            }
        }
        return total;       
    }
}
