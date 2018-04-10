class Solution {
    public String decodeString(String s) {
        int idx = s.indexOf('[');
        if (idx < 0) return s;

        StringBuilder sb = new StringBuilder();
        int prev = 0;
        while (idx > 0) {
            int count = 1;
            for (int i = idx + 1 ; i < s.length() ; i++) {
                char c = s.charAt(i);
                if (c == '[') count++;
                else if (c == ']') count--;
                if (count == 0) {
                    int digitBegin = idx - 1;
                    while (digitBegin >= 0 && s.charAt(digitBegin) >= '0' && s.charAt(digitBegin) <= '9') digitBegin--;
                    sb.append(s.substring(prev, ++digitBegin));
                    String decode = decodeString(s.substring(idx + 1, i));
                    for (int k = Integer.parseInt(s.substring(digitBegin, idx)) ; k > 0 ; k--) sb.append(decode);
                    prev = i + 1;
                    break;
                }
            }
            idx = s.indexOf('[', prev + 1);
        }
        sb.append(s.substring(prev));
        return sb.toString();
    }
}
