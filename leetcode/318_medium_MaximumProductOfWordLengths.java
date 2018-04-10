class Solution {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : words) {
            int idx = getIndex(s);
            map.put(idx, Math.max(s.length(), map.getOrDefault(idx, 0)));
        }
        int maxLen = 0;
        for (Integer k1 : map.keySet()) {
            for (Integer k2 : map.keySet()) {
                if (k1 < k2 && (((int)k1) & ((int)k2)) == 0) {
                    maxLen = Math.max(maxLen, map.get(k1) *map.get(k2));
                }
            }
        }
        return maxLen;
    }

    private int getIndex(String s) {
        int idx = 0;
        for (char c : s.toCharArray()) {
            idx |= (1 << (c - 'a'));
        }
        return idx;
    }
}
