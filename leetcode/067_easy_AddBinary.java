class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = 0 ; i < Math.max(lenA, lenB) ; i++) {
            int sum = carry;
            if (i < lenA) sum += (a.charAt(lenA - i - 1) - '0');
            if (i < lenB) sum += (b.charAt(lenB - i - 1) - '0');
            carry = sum / 2;
            sum = sum % 2;
            sb.append(String.valueOf(sum));
        }
        if (carry > 0) sb.append("1");
        return sb.reverse().toString();
    }
}
