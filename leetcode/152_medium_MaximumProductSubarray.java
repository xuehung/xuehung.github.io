// Importance:xxx
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int maxProduct = nums[0];
        int minProduct = nums[0];
        for (int i = 1 ; i < nums.length ; i++) {
            int n = nums[i];
            int tempMax = Math.max(Math.max(n * maxProduct, n * minProduct), n);
            int tempMin = Math.min(Math.min(n * maxProduct, n * minProduct), n);
            maxProduct = tempMax;
            minProduct = tempMin;
            max = Math.max(max, maxProduct);
        }
        return max;
    }
}
