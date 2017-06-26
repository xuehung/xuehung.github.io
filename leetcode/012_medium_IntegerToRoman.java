// Importance: x
// Do it more elegantly
public class Solution {
    public String intToRoman(int num) {
        String output = "";
        if (num >= 1000) {
            output = repeat("M", num / 1000);
            num -= 1000 * (num / 1000);
        }
        if (num >= 900) {
            output += "CM";
            num -= 900;
        }
        if (num >= 500) {
            output += "D";
            num -= 500;
        }
        if (num >= 400) {
            output += "CD";
            num -= 400;
        }
        if (num >= 100) {
            output += repeat("C", num / 100);
            num -= 100 * (num / 100);
        }
        if (num >= 90) {
            output += "XC";
            num -= 90;
        }
        if (num >= 50) {
            output += "L";
            num -= 50;
        }
        if (num >= 40) {
            output += "XL";
            num -= 40;
        }
        if (num >= 10) {
            output += repeat("X", num / 10);
            num -= (num / 10) * 10;
        }
        if (num >= 9) {
            output += "IX";
            num -= 9;
        }
        if (num >= 5) {
            output += "V";
            num -= 5;
        }
        if (num >= 4) {
            output += "IV";
            num -= 4;
        }
        if (num >= 1) {
            output += repeat("I", num);
        }
        return output;
    }
    private String repeat(String c, int num) {
        String output = "";
        for (int i = 0 ; i < num ; i++) {
            output = c + output;
        }
        return output;
    }
}
