public class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1 ; i < num.length() ; i++) {
            for (int j = i + 1 ; j < num.length() ; j++) {
                if (isAdditiveNumber(num.substring(0, i), num.substring(i, j), num.substring(j))) return true;
            }
        }
        return false;
    }
    public boolean isAdditiveNumber(String a, String b, String num) {
        if (!isValidNumber(a) || !isValidNumber(b) || !isValidNumber(num)) return false;
        String abSum = add(a, b);
        if (abSum.length() > num.length()) return false;
        if (abSum.length() == num.length()) return abSum.equals(num);
        if (!num.substring(0, abSum.length()).equals(abSum)) return false;
        return isAdditiveNumber(b, abSum, num.substring(abSum.length()));
    }

    public boolean isValidNumber(String num) {
        return num.length() == 1 || num.charAt(0) != '0';
    }

    public String add(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int newLen = Math.max(lenA, lenB);
        int[] sum = new int[newLen];
        int carry = 0;
        for (int i = 0 ; i < newLen ; i++) {
            int idx = newLen - i - 1;
            sum[idx] = carry;
            if (lenA - i > 0) sum[idx] += (a.charAt(lenA - i - 1) - '0');
            if (lenB - i > 0) sum[idx] += (b.charAt(lenB - i - 1) - '0');
            if (sum[idx] >= 10) {
                carry = 1;
                sum[idx] %= 10;
            } else {
                carry = 0;
            }
        }
        char[] result = new char[carry > 0 ? newLen + 1 : newLen];
        for (int i = 0 ; i < newLen ; i++) {
            result[i + carry] = (char)(sum[i] + '0');
        }
        if (carry > 0) result[0] = '1';
        return String.valueOf(result);
    }
}
