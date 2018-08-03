// Importance:x
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int a = 0, b = 0;
        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i - 1] > nums[i]) {
                if (a == 0) a = 2;
                if (b != 0) a = Math.max(a, b + 1);
            } else if (nums[i - 1] < nums[i]) {
                if (b == 0) b = 2;
                if (a != 0) b = Math.max(b, a + 1);
            } else {
                continue;
            }
        }   
        return Math.max(1, Math.max(a, b)); 
    }   
}
