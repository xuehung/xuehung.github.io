// Importance:xxx
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        helper(result, nums, stack, 0, false);
        return result;
    }

    private void helper(List<List<Integer>> result, int[] nums, Stack<Integer> stack, int idx, boolean pickPrev)
    {
        if (idx == nums.length) {
            List<Integer> ans = new ArrayList<>();
            for (int n : stack) ans.add(n);
            result.add(ans);
            return;
        }
        if(!pickPrev || (idx > 0 && nums[idx - 1] != nums[idx])) helper(result, nums, stack, idx + 1, false);
        stack.push(nums[idx]);
        helper(result, nums, stack, idx + 1, true);
        stack.pop();
    }
}
