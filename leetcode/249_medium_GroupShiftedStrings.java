// Google
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
            String key = getKey(s);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String getKey(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1 ; i < s.length() ; i++) {
            int diff = s.charAt(i) - s.charAt(i - 1);
            sb.append(',').append((diff + 26) % 26);
        }
        return sb.toString();
    }
}
