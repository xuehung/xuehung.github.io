public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        for (int n : nums) {
            if (n != nums[len]) {
                len++;
                nums[len] = n;
            }
        }
        return len + 1;
    }
}
