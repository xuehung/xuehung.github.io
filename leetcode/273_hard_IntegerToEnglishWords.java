class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        int i = 3;
        int base = 1000000000;
        String output = "";
        while (i >= 0) {
            if (num >= base) output += " " + helper(num / base) + " " + THOUSANDS[i];
            num %= base;
            base /= 1000;
            i--;
        }
        return output.trim();
    }

    private String helper(int num) {
        String output;
        if (num == 0) return "";
        else if (num < 20) return LESS_THAN_20[num];
        else if (num >= 100) {
            output = LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        } else {
            output = TENS[num / 10] + " " + helper(num % 10);
        }
        return output.trim();
    }
}
