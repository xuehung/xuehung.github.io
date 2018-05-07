class Solution {
    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int[] nums = new int[n];
        nums[0] = 1;
        nums[1] = 2;
        int after = 1;
        int before = 1;
        int count = 1;
        while (after < n) {
            int val = nums[after - 1] == 1 ? 2 : 1;
            nums[after++] = val;
            if (val == 1) count++;
            if (nums[before++] == 2 && after < n) {
                nums[after++] = val;
                if (val == 1) count++;
            }
        }
        return count;
    }
}
