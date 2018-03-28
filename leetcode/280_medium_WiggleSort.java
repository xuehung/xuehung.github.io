class Solution {
    public void wiggleSort(int[] nums) {
        boolean isSmallerThanPrevious = false;
        for (int i = 1 ; i < nums.length ; i++) {
            int a = nums[i - 1];
            int b = nums[i];
            boolean shouldSwap = isSmallerThanPrevious ? b > a : b < a;
            if (shouldSwap) {
                nums[i] = a;
                nums[i - 1] = b;
            }
            isSmallerThanPrevious = !isSmallerThanPrevious;
        }
    }
}
