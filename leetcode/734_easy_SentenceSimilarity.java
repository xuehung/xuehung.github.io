class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> dict = new HashMap<>();
        for (String[] p : pairs) {
            dict.computeIfAbsent(p[0], k -> new HashSet<>()).add(p[1]);
            dict.computeIfAbsent(p[1], k -> new HashSet<>()).add(p[0]);
        }
        for (int i = 0 ; i < words1.length ; i++) {
            if (!words1[i].equals(words2[i])) {
                Set<String> set = dict.get(words1[i]);
                if (set == null || !set.contains(words2[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
