// Importance:xxx
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int candidate = 0;
        for (int i = 1 ; i < n ; i++) {
            if (knows(candidate, i)) candidate = i;
        }
        for (int i = 0 ; i < n ; i++) {
            if (i != candidate && ((i < candidate && knows(candidate, i)) || !knows(i, candidate))) return -1;
        }
        return candidate;
    }

}
public class Solution extends Relation {
    Map<String, Boolean> cache = new HashMap<>();
    public int findCelebrity(int n) {
        Set<Integer> notCelebrity = new HashSet<>();
        for (int i = 0 ; i < n ; i++) {
            boolean isCelebrity = !notCelebrity.contains(i);
            for (int j = 0 ; j < n && isCelebrity; j++) {
                if (i != j) {
                    if (_knows(i, j)) isCelebrity = false;
                    else notCelebrity.add(j);
                }
            }
            if (isCelebrity) {
                for (int j = 0 ; j < n && isCelebrity ; j++) {
                    if (i != j) isCelebrity = _knows(j, i);
                }
                if (isCelebrity) return i;
            }
        }

        return -1;
    }

    private boolean _knows(int i, int j) {
        String key = i + ":" + j;
        return cache.computeIfAbsent(key, k -> knows(i, j));
    }
}
