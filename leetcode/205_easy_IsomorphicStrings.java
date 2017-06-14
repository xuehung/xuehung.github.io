public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] mapping = new int[256];
        int[] used = new int[256];
        for (int i = 0 ; i < s.length() ; i++) {
            int target = t.charAt(i);
            int source = s.charAt(i);
            if (mapping[source] == 0) {
                if (used[target] == 1) return false;
                mapping[source] = target;
                used[target] = 1;
            } else {
                if (mapping[source] != target) return false;
            }
        }
        return true;
    }
}
