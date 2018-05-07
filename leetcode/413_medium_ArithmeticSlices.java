class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int len = A.length;
        int begin = 0;
        while (begin + 1 < len) {
            int diff = A[begin + 1] - A[begin];
            int end = begin;
            while (end + 1 < len && A[end + 1] - A[end] == diff) end++;
            int n = end - begin + 1;
            if (n > 2) {
                count += (n - 1) * (n - 2) / 2;
            }
            begin = end;
        }
        return count;
    }
}
