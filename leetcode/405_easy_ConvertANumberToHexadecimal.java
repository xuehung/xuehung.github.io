public class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        String output = "";
        int move = 0;
        while (num != 0 && ++move <= 8) {
            int x = num & 0xf;
            num = num >> 4;
            if (x < 10) output = x + output;
            else {
                output = (char)((x - 10) + 'a') + output;
            }
        }
        return output;
    }
}
