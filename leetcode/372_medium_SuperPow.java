// Importance:xx
class Solution {
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length - 1);
    }

    public int superPow(int a, int[] b, int begin) {
        if (a % 1337 == 0) return 0;
        if (begin == 0) return superPow(a, b[0]);
        return (superPow(superPow(a, b, begin - 1), 10) * superPow(a, b[begin])) % 1337;
    }

    public int superPow(int a, int b) {
        int result = 1;
        a = a % 1337;
        for (int i = 0 ; i < b ; i++) {
            result = (result * a) % 1337;
        }
        return result;
    }
}
