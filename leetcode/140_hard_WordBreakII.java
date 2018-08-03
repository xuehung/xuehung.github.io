// Google
// Importance: xxx
public class Solution {

    Map<String, List<String>> cache = new HashMap<String, List<String>>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<>(wordDict));
    }

    public List<String> wordBreak(String s, Set<String> wordDict) {

        if (cache.containsKey(s)) return cache.get(s);
        List<String> result = new ArrayList<String>();
        if (wordDict.contains(s)) result.add(s);

        for (int i = 1 ; i < s.length() ; i++) {
            String firstWord = s.substring(0, i);
            if (wordDict.contains(firstWord)) {
                List<String> rest = wordBreak(s.substring(i, s.length()), wordDict);
                for (String t : rest) {
                    result.add(firstWord + " " + t);
                }
            }
        }

        cache.put(s, result);
        return result;
    }
}
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) return result;
        helper(s, 0, new HashSet<>(wordDict), new Stack<>(), result);
        return result;
    }

    private void helper(String s, int idx, Set<String> dict, Stack<String> path, List<String> result) {
        if (idx == s.length()) {
            result.add(String.join(" ", path));
        }
        for (int i = idx ; i < s.length() ; i++) {
            String word = s.substring(idx, i + 1);
            if (dict.contains(word)) {
                path.push(word);
                helper(s, i + 1, dict, path, result);
                path.pop();
            }
        }
    }
}
