class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String p : paths) {
            String[] tokens = p.split("\\s+");
            for (int i = 1 ; i < tokens.length ; i++) {
                String t = tokens[i];
                int left = t.indexOf("(");
                int right = t.indexOf(")");
                String filename = t.substring(0, left);
                String content = t.substring(left + 1, right);
                map.computeIfAbsent(content, k -> new ArrayList<>()).add(tokens[0] + "/" + filename);
            }
        }
        List<List<String>> output = new ArrayList<>();
        for (List<String> v : map.values()) {
            if (v.size() > 1) output.add(v);
        }
        return output;
    }
}
