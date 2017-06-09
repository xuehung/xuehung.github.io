public class Solution {
    public String reverseString(String s) {
        int len = s.length();
        char[] ca = new char[len];
        for (int i = 0 ; i < len ; i++) ca[i] = s.charAt(len - i - 1);
        return String.valueOf(ca);
    }
}
