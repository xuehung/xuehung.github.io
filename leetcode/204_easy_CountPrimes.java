// Importance:xxxx
class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        boolean[] isNotPrime = new boolean[n];
        int count = n / 2;
        for (int i = 3 ; i * i < n ; i += 2) {
            if (isNotPrime[i]) {
                continue;
            }
            int doubleI = 2 * i;
            for (int k = i * i ; k < n ; k += doubleI) {
                if (!isNotPrime[k]) {
                    isNotPrime[k] = true;
                    count--;
                }
            }
        }
        return count;
    }
}
