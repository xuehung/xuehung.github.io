// Importance:xxxx
// Google
class Solution {

    private void _addResult( List<List<Integer>> result, int i, int j) {
        if (i == j) return;
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        result.add(list);
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0 ; i < words.length ; i++) map.put(words[i], i);
        for (int i = 0 ; i < words.length ; i++) {
            String word = words[i];
            for (int j = 0 ; j <= word.length() ; j++) {
                String a = word.substring(0, j);
                String b = word.substring(j);
                if (_isPalidrom(b)) {
                    Integer idx = map.get(new StringBuilder(a).reverse().toString());
                    if (idx != null) _addResult(result, i, idx);
                }
                if (_isPalidrom(a) && a.length() != 0) {
                    Integer idx = map.get(new StringBuilder(b).reverse().toString());
                    if (idx != null) _addResult(result, idx, i);
                }
            }

        }
        return result;
    }

    private boolean _isPalidrom(String str) {
        int lo = 0, hi = str.length() - 1;
        while (lo < hi) {
            if (str.charAt(lo++) != str.charAt(hi--)) return false;
        }
        return true;
    }
}
