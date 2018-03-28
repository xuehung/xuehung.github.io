// Importance:xxx
class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNum = new int[n];
        uglyNum[0] = 1;
        int ptr2 = 0, ptr3 = 0, ptr5 = 0;
        for (int i = 1 ; i < n ; i++) {
            int next2 = 2*uglyNum[ptr2];
            int next3 = 3*uglyNum[ptr3];
            int next5 = 5*uglyNum[ptr5];
            uglyNum[i] = Math.min(Math.min(next2, next3), next5);
            if (next2 == uglyNum[i]) ptr2++;
            if (next3 == uglyNum[i]) ptr3++;
            if (next5 == uglyNum[i]) ptr5++;
        }
        return uglyNum[n - 1];
    }
}
