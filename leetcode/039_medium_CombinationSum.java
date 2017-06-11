public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> combines = new ArrayList<>();
        helper(candidates, target, 0, combines, result);
        return result;
    }
    public void helper(int[] candidates, int target, int index, List<Integer> combines, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combines));
        } else if (target > 0 && index < candidates.length) {
            combines.add(candidates[index]);
            helper(candidates, target - candidates[index], index, combines, result);
            combines.remove(combines.size() - 1);
            helper(candidates, target, index + 1, combines, result);
        }
    }
}
