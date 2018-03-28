class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> queue = new HashSet<>();
        queue.add(beginWord);
        int len = 1;
        while (!queue.isEmpty()) {
            Set<String> newQueue = new HashSet<>();
            for (String word : queue) {
                if (word.equals(endWord)) return len;
                for (Iterator<String> it = dict.iterator() ; it.hasNext() ; ) {
                    String next = it.next();
                    if (isConnected(word, next)) {
                        newQueue.add(next);
                        it.remove();
                    }
                }
            }
            len++;
            queue = newQueue;
        }
        return 0;
    }

    private boolean isConnected(String a, String b) {
        if (a.length() != b.length()) return false;
        boolean isDiff = false;
        for (int i = 0 ; i < a.length() ; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (isDiff) return false;
                isDiff = true;
            }
        }
        return isDiff;
    }
}
