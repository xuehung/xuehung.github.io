class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs == null || strs.length == 0) return sb.toString();
        for (int i = 0 ; i < strs[0].length() ; i++) {
            char c = strs[0].charAt(i);
            boolean hasPrefix = true;
            for (int j = 1 ; j < strs.length ; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    hasPrefix = false;
                    break;
                }
            }
            if (hasPrefix) {
                sb.append(c);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}
