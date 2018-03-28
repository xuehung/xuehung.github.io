class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words.length == 0 || word1 == null || word2 == null) return 0;
        int idx1 = -1, idx2 = -1;
        int minDis = words.length;
        for (int i = 0 ; i < words.length ; i++) {
            String word = words[i];
            if (word1.equals(word)) idx1 = i;
            if (word2.equals(word)) idx2 = i;
            if (idx1 >= 0 && idx2 >= 0) minDis = Math.min(minDis, Math.abs(idx1 - idx2));
        }
        return minDis;
    }
}
