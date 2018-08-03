// Google
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        List<Interval> result = new ArrayList<>();
        for (int i = 0 ; i < intervals.size() ; i++) {
            Interval iv = intervals.get(i);
            int start = iv.start, end = iv.end;
            while (i + 1 < intervals.size()) {
                Interval nextIv = intervals.get(i + 1);
                if (nextIv.start <= end) {
                    end = Math.max(end, nextIv.end);
                    i++;
                } else break;
            }
            result.add(new Interval(start, end));
        }

        return result;
    }
}
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
