public class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        char[] ca = new char[len];
        for (int i = 0 ; i < len ; i++) ca[i] = s.charAt(i);
        int wordBegin = 0;
        int wordEnd = 0;
        while (wordBegin < len) {
            while (wordBegin < len && ca[wordBegin] == ' ') wordBegin++;
            wordEnd = wordBegin;
            while (wordEnd < len && ca[wordEnd] != ' ') wordEnd++;
            if (wordBegin < len) {
                for (int i = wordBegin, j = wordEnd - 1; i < j ; i++, j--) {
                    char c = ca[i];
                    ca[i] = ca[j];
                    ca[j] = c;
                }
            }
            wordBegin = wordEnd;
        }
        return String.valueOf(ca);
    }
}
