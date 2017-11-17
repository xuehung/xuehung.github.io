class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return; 
        k = k % len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int a, int b) {
        while (a < b) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
            a++;
            b--;
        }
    }
}
