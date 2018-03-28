// Importance:x
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;

        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int i = 0 ; i < nums.length ; i++) {
            int n = nums[i];
            if (n <= small) small = n;
            else if (n <= big) big = n;
            else return true;
        }
        return false;
    }
}
