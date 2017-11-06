class Solution {
    public String addStrings(String num1, String num2) {
        List<Integer> digits = new ArrayList<>();
        int overflow = 0;
        for (int i1 = num1.length() - 1, i2 = num2.length() - 1 ; i1 >= 0 || i2 >= 0 ; i1--, i2--) {
            int a = 0, b = 0;
            if (i1 >= 0) {
                a = num1.charAt(i1) - '0';
            }
            if (i2 >= 0) {
                b =  num2.charAt(i2) - '0';
            }
            overflow = a + b + overflow;
            digits.add(overflow % 10);
            overflow = overflow / 10;
        }
        if (overflow > 0) digits.add(1);
        StringBuilder sb = new StringBuilder();
        for (int n : digits) sb.append(String.valueOf(n));
        return sb.reverse().toString();
    }
}
