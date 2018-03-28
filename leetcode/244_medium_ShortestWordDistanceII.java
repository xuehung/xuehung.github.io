class WordDistance {

    Map<String, Integer> cache = new HashMap<>();
    Map<String, List<Integer>> index = new HashMap<>();
    public WordDistance(String[] words) {
        for (int i = 0 ; i < words.length ; i++) {
            String word = words[i];
            index.computeIfAbsent(word, k -> new ArrayList<>()).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        if (word1.compareTo(word2) > 0) return shortest(word2, word1);
        String key = word1 + ":" + word2;
        return cache.computeIfAbsent(key, k -> {
            int dis = Integer.MAX_VALUE;
            for (int i : index.get(word1)) {
                for (int j : index.get(word2)) {
                    dis = Math.min(Math.abs(i - j), dis);
                }
            }
            return dis;
        });
    }
}
