class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        for (int i = 0 ; i < len ; i++) {
            int n = nums[i];
            while (n != i && n < len) {
                int tmp = nums[n];
                nums[n] = n;
                nums[i] = tmp;
                n = tmp;
            }
        }
        for (int i = 0 ; i < len ; i++) {
            if (i != nums[i]) return i;
        }
        return len;
    }
}
