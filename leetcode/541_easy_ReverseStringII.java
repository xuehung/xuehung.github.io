public class Solution {
    public String reverseStr(String s, int k) {
        char[] ca = s.toCharArray();
        int len = s.length();
        for (int i = 0 ; i < len ; i += 2 * k)
        {
            int begin = i;
            int end = Math.min(len - 1, i + k - 1);
            while (begin < end) {
                char tmp = ca[begin];
                ca[begin] = ca[end];
                ca[end] = tmp;
                begin++;
                end--;
            }
        }
        return String.valueOf(ca);
    }
}
