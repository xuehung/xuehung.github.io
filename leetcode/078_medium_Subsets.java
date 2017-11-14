class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, nums, new ArrayList<>(), 0);
        return result;
    }
    private void helper(List<List<Integer>> result, int[] nums, List<Integer> current, int ptr) {
        if (ptr >= nums.length) {
            result.add(new ArrayList<Integer>(current));
        } else {
            helper(result, nums, current, ptr + 1);
            current.add(nums[ptr]);
            helper(result, nums, current, ptr + 1);
            current.remove(current.size() - 1);
        }
    }
}
