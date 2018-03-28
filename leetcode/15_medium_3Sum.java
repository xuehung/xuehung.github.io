// Importance:xx
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i++) {
            int i2 = i + 1;
            int i3 = nums.length - 1;
            if (i2 < i3 && (i == 0 || nums[i - 1] != nums[i])) {
                while (i2 < i3) {
                    int sum = nums[i] + nums[i2] + nums[i3];
                    if (sum == 0) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[i2]);
                        ans.add(nums[i3]);
                        result.add(ans);
                        i2++;
                        i3--;
                        while (i2 < nums.length && nums[i2] == nums[i2 - 1]) i2++;
                        while (i3 >= 0 && nums[i3] == nums[i3 + 1]) i3--;
                    } else if (sum < 0) {
                        i2++;
                    } else {
                        i3--;
                    }
                }
            }
        }
        return result;
    }
}
