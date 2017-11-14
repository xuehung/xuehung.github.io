class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, Integer> mapping = new HashMap<>();
        for (String s : strs) {
            String key = getKey(s);
            Integer idx = mapping.get(key);
            if (idx == null) {
                mapping.put(key, result.size());
                idx = result.size();
                result.add(new ArrayList<String>());
            }
            result.get(mapping.get(key)).add(s);
        }
        return result;
    }
    private String getKey(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) counter[c - 'a']++;
        String key = "";
        for (int i = 0 ; i < counter.length ; i++) key += ((char)('a' + i) + String.valueOf(counter[i]));
        return key;
    }
}
