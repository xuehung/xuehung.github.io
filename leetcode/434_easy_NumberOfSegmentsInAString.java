public class Solution {
    public int countSegments(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int count = s.charAt(0) == ' ' ? 0 : 1;
        for (int i = 1 ; i < len ; i++) {
            if (s.charAt(i) != ' ' && s.charAt(i - 1) == ' ') count++;
        }
        return count;
    }
}
