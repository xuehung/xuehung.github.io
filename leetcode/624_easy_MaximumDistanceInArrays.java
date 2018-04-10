class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int dis = 0;
        for (List<Integer> list : arrays) {
            if (!list.isEmpty()) {
                int currentMin = list.get(0);
                int currentMax = list.get(list.size() - 1);
                if (min != Integer.MAX_VALUE) dis = Math.max(dis, Math.abs(max - currentMin));
                if (max != Integer.MIN_VALUE) dis = Math.max(dis, Math.abs(currentMax - min));
                min = Math.min(currentMin, min);
                max = Math.max(currentMax, max);
            }
        }
        return dis;
    }
}
