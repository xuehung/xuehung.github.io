class NumArray {
    int total = 0;
    int[] left, right;
    public NumArray(int[] nums) {
        int len = nums.length;
        left = new int[len];
        right = new int[len];
        for (int i = 0 ; i < len ; i++) {
            left[i] = total;
            total += nums[i];
        }
        for (int i = len - 2 ; i >= 0 ; i--) {
            right[i] = right[i + 1] + nums[i + 1];
        }
    }

    public int sumRange(int i, int j) {
        Integer fromLeft = left[i];
        Integer fromRight = right[j];
        return total - fromLeft - fromRight;
    }
}
