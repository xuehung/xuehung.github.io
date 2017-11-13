class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, "", n, n);
        return result;
    }
    public void helper(List<String> result, String s, int open, int close)
    {
        if (open > close || open * close < 0) return;
        if (open == 0 && close == 0) result.add(s);
        else {
            helper(result, s + "(", open - 1, close);
            helper(result, s + ")", open, close - 1);
        }
    }
}
