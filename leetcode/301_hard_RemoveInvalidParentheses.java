// Importance:xx
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int numberToRemove = getMinLen(s);
        Set<String> result = new HashSet<>();
        helper(result, new ArrayList<>(), s.toCharArray(), 0, 0, numberToRemove);
        return new ArrayList<String>(result);
    }

    private void helper(Set<String> result, List<Character> current, char[] s, int idx, int open, int numberToRemove) {
        if (open < 0) return;
        else if (idx == s.length && open == 0 && numberToRemove == 0) {
            StringBuilder builder = new StringBuilder();
            for (char c : current) builder.append(c);
            result.add(builder.toString());
        } else if (idx < s.length) {
            char c = s[idx];
            current.add(c);
            if (c != '(' && c != ')') {
                helper(result, current, s, idx + 1, open, numberToRemove);
                current.remove(current.size() - 1);
            } else {
                helper(result, current, s, idx + 1, open + (c == '(' ? 1 : -1), numberToRemove);
                current.remove(current.size() - 1);
                if (numberToRemove > 0) {
                    helper(result, current, s, idx + 1, open, numberToRemove - 1);
                }
            }
        }
    }

    private int getMinLen(String s) {
        int invalidLen = 0;
        int open = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') open++;
            else if (c == ')') open--;
            if (open < 0) {
                invalidLen += (-open);
                open = 0;
            }
        }
        return invalidLen + Math.abs(open);
    }
}
