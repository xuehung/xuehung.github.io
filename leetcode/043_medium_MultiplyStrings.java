class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];
        for (int i = len1 - 1 ; i >= 0 ; i--) {
            for (int j = len2 - 1 ; j >= 0 ; j--) {
                result[(len1 - i - 1) + (len2 - j - 1)] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        for (int i = 0 ; i < result.length ; i++) {
            if (result[i] >= 10) {
                result[i + 1] += (result[i] / 10);
                result[i] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = result.length - 1 ; i >= 0 ; i--) {
            if (result[i] != 0 || sb.length() != 0) {
                sb.append(String.valueOf(result[i]));
            }
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}
