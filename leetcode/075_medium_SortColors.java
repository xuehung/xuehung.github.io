// Importance: xx
public class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            int val = nums[i];
            nums[i] = 2;
            if (val == 0) count0++;
            if (val == 1) count1++;
            if (count0 > 0) nums[count0 - 1] = 0;
            if (count1 > 0) nums[count0 + count1 - 1] = 1;
        }
    }
}
