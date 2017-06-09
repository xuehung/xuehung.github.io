public class Solution {
    public int addDigits(int num) {
        num = addDigitsHelper(num); // at most 99
        num = addDigitsHelper(num); // at most 18
        return addDigitsHelper(num); // at most 9
    }

    public int addDigitsHelper(int num) {
        if (num < 10) return num;
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
}
