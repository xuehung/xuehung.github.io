public class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        int begin = 0;
        for (int i = 1 ; i < s.length() ; i++) {
            if ((chars[i] == ' ' || i == s.length() - 1) && chars[i - 1] != ' ') {
                reverse(chars, begin, i == s.length() - 1 ? i : i - 1);
            }
            if (chars[i] != ' ' && chars[i - 1] == ' ') {
                begin = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i++) {
            if (chars[i] != ' ') sb.append(chars[i]);
            else if (i != 0 && chars[i - 1] != ' ') sb.append(chars[i]);
        }
        return sb.toString().trim();
    }

    public void reverse(char[] s, int begin, int end) {
        while (begin < end) {
            char tmp = s[begin];
            s[begin] = s[end];
            s[end] = tmp;
            begin++;
            end--;
        }
    }
}
