public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int upper = n;
        int lower = 1;
        int myGuess;
        while (true) {
            myGuess = (upper - lower) / 2 + lower;
            int r = guess(myGuess);
            if (r == 0) {
                break;
            } else if (r > 0) {
                lower = myGuess + 1;
            } else if (r < 0) {
                upper = myGuess - 1;
            }
        }
        return myGuess;
    }
}
