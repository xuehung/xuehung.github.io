public class Solution {
    public int[] plusOne(int[] digits) {
        int overflow = 1;
        int[] newDigits = new int[1];
        for (int i = digits.length - 1 ; i >= 0 ; i--) {
            digits[i] += overflow;
            if (digits[i] >= 10) {
                overflow = 1;
                digits[i] -= 10;
            } else {
                overflow = 0;
            }
        }
        if (overflow > 0) {
            newDigits = new int[digits.length + 1];
            System.arraycopy(digits, 0, newDigits, 1, digits.length);
            newDigits[0] = 1;
        }
        return overflow == 0 ? digits : newDigits;
    }
}
