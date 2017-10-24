public class Solution {
    public int findDuplicate(int[] nums) {
        int lower = 1, upper = nums.length - 1;
        while (lower < upper) {
            int same = 0, small = 0, big = 0;
            int middle = (upper - lower) / 2 + lower;
            int half = (upper - lower + 1) / 2;
            for (int n : nums) {
                if (n > upper || n < lower) continue;
                if (n == middle) same++;
                else if (n < middle) small++;
                else big++;
            }
            if (same > 1) return middle;
            else if (small < big) lower = middle + 1;
            else upper = middle - 1;


        }
        return lower;
    }
}
