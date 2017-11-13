public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0 ; i < numRows ; i++) sb[i] = new StringBuilder();
        int loop = numRows * 2 - 2;
        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            int pos = i % loop;
            pos = (pos < numRows) ? pos : numRows - (pos - numRows) - 2;
            sb[pos].append(c);
        }
        for (int i = 1 ; i < numRows ; i++) sb[0].append(sb[i].toString());
        return sb[0].toString();
    }
}
