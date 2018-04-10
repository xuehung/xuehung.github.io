class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> result = new HashSet<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                int target = nums[i];
                if (nums[target - 1] == target) {
                    result.add(target);
                    i++;
                } else {
                    int tmp = nums[target - 1];
                    nums[target - 1] = nums[i];
                    nums[i] = tmp;
                }
            } else {
                i++;
            }
        }
        return new ArrayList<>(result);
    }
}
