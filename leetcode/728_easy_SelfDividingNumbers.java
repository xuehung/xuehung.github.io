class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        while (left <= right) {
            if (isSelfDividing(left)) result.add(left);
            left++;
        }
        return result;
    }

    private boolean isSelfDividing(int n) {
        int m = n;
        while (m > 0) {
            int d = m % 10;
            if (d == 0 || n % d != 0) return false;
            m /= 10;
        }
        return true;
    }
}
