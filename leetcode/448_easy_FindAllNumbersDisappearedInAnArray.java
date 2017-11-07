class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> out = new ArrayList<>();
        for (int n : nums) {
            int i = n;
            while (nums[i - 1] != i) {
                int tmp = nums[i - 1];
                nums[i - 1] = i;
                i = tmp;
            }
        }
        for (int i = 0 ; i < nums.length ; i++)  {
            if(nums[i] != i + 1) out.add(i + 1);
        }
        return out;
    }
}
