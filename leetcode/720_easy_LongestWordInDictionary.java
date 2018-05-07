class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() == b.length()) return a.compareTo(b);
            return a.length() - b.length();
        });
        Map<String, Boolean> canBuilt = new HashMap<>();
        String longest = null;
        for (int i = 0 ; i < words.length ; i++) {
            String w = words[i];
            Boolean ok = false;
            if (w.length() == 1) ok = true;
            else {
                Boolean prev = canBuilt.get(w.substring(0, w.length() - 1));
                if (prev != null && prev == true) {
                    ok = true;
                }   
            }
            if (ok) {
                canBuilt.put(w, true);
                if (longest == null || longest.length() < w.length()) {
                    longest = w;
                }
            }
        }
        return longest;
    }
}
