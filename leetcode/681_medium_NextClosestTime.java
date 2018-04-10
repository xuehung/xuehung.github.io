class Solution {
    String minTime;
    int minDist;
    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        minDist = Integer.MAX_VALUE;
        for (int i = 0 ; i < time.length() ; i++) {
            if (i != 2) set.add(time.charAt(i) - '0');
        }
        helper(new int[4], -1, set, getIntTime(time));
        return minTime == null ? time : minTime;
    }

    private int getIntTime(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
    }

    private void helper(int[] stack, int idx, Set<Integer> set, int time) {
        if (idx == 0 && stack[0] > 2) return;
        if (idx == 1 && stack[0] == 2 && stack[1] > 4) return;
        if (idx == 2 && stack[2] >= 6) return;
        if (idx == 3) {
            String newTime = String.format("%d%d:%d%d", stack[0], stack[1], stack[2], stack[3]);
            int dist = getIntTime(newTime) - time;
            if (dist < 0) dist += (24*60);
            if (dist != 0 && dist < minDist) {
                minDist = dist;
                minTime = newTime;
            }
        } else {
            idx++;
            for (int n : set) {
                stack[idx] = n;
                helper(stack, idx, set, time);
            }
        }
    }
}
