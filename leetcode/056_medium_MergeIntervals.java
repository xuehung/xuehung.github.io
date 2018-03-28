class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> {
            return a.start - b.start;
        });
        List<Interval> result = new ArrayList<>();
        Interval last = null;
        for (Interval interval : intervals) {
            if (last == null) last = interval;
            else {
                if (last.end < interval.start) {
                    result.add(last);
                    last = interval;
                } else {
                    last.end = Math.max(interval.end, last.end);
                }
            }
        }
        if (last != null) result.add(last);
        return result;
    }
}
