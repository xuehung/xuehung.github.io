class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        List<Integer> times = new ArrayList<>();
        for (Interval iv : intervals) {
            times.add(iv.start);
            times.add(-iv.end);
        }

        Collections.sort(times, (a, b) -> {
            if (Math.abs(a) == Math.abs(b)) return a - b;
            return Math.abs(a) - Math.abs(b);
        });

        int count = 0;
        int maxCount = 0;
        for (int i : times) {
            count += (i >= 0 ? 1 : -1);
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
