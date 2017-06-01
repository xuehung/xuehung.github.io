public class Solution {
    public int majorityElement(int[] nums) {
        int maj = -1;
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                maj = n;
                count = 1;
            } else {
                count += (maj == n ? 1 : -1);
            }
        }
        return maj;
    }
}
