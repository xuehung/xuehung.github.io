class Solution {
    public int removeElement(int[] nums, int val) {
        int ptr = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            int n = nums[i];
            if (n != val) {
                nums[ptr++] = n;
            }
        }
        return ptr;
    }
}
