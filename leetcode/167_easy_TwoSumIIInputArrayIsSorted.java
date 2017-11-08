class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int s = numbers[left] + numbers[right];
            if (s > target) right--;
            else if (s < target) left++;
            else {
                ans[0] = left + 1;
                ans[1] = right + 1;
                break;
            }
        }
        return ans;
    }
}
