public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int tmpLen = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c == ' ') tmpLen = 0;
            else {
                tmpLen++;
                len = tmpLen;
            }
        }
        return len;
    }
}
