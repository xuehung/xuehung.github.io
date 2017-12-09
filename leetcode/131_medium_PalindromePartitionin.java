class Solution {
    Map<String, List<List<String>>> cache = new HashMap<>();
    public List<List<String>> partition(String s) {
        if (!cache.containsKey(s)) {
            List<List<String>> result = new ArrayList<>();
            if (isPalindrome(s)) {
                List<String> row = new ArrayList<>();
                row.add(s);
                result.add(row);
            }
            for (int i = 1 ; i < s.length() ; i++) {
                String left = s.substring(0, i);
                if (isPalindrome(left)) {
                    List<List<String>> right = partition(s.substring(i, s.length()));
                    for (List<String> list : right) {
                        List<String> newAns = new ArrayList<>();
                        newAns.add(left);
                        newAns.addAll(list);
                        result.add(newAns);
                    }
                }
            }
            cache.put(s, result);
        }
        return cache.get(s);
    }

    private boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 1) return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
