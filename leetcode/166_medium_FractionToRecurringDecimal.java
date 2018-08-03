// Importance:xxxxx
// Google
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        long n = numerator, d = denominator;
        if (n == 0) return "0";
        if (n < 0 && d < 0) return fractionToDecimal(-n, -d);
        if (n < 0 || d < 0) return "-" + fractionToDecimal(Math.abs(n), Math.abs(d));
        return fractionToDecimal(n, d);
    }

    public String fractionToDecimal(long numerator, long denominator) {
        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        while (numerator != 0) {
            long r = numerator % denominator;
            long q = numerator / denominator;
            if (r != 0 && sb.length() == 0) sb.append(q).append('.');
            else sb.append(q);
            numerator = r * 10;
            if (map.containsKey(numerator)) {
                sb.insert((int)map.get(numerator), '(').append(')');
                break;
            }
            map.put(numerator, sb.length());
        }
        return sb.toString();
    }
}
