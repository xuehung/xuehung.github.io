public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> repeat = new HashSet<>();
        while (!repeat.contains(n)) {
            repeat.add(n);
            int nextN = 0;
            while (n != 0) {
                int digit = n % 10;
                nextN += digit * digit;
                n = n / 10;
            }
            n = nextN;
        }
        return n == 1;
    }
}
