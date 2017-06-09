public class Solution {
    public String countAndSay(int n) {
        String str = new String("1");
        for (int i = 1 ; i < n ; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0 ; j < str.length() ; j++) {
                int count = 1;
                while (j + 1 < str.length() && str.charAt(j + 1) == str.charAt(j)) {
                    j++;
                    count++;
                }
                sb.append(count+"").append(str.charAt(j));
            }
            str = sb.toString();
        }
        return str;
    }
}
