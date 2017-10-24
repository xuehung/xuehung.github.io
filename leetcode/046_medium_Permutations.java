// Importance: xxx
// Do this faster!
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }
        return permute(numSet);
    }

    public List<List<Integer>> permute(Set<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.size() == 1) {
            List<Integer> permutation = new ArrayList<>();
            permutation.add(nums.iterator().next());
            result.add(permutation);
            return result;
        }
        Set<Integer> numsCopy = new HashSet<>(nums);
        for (int n : nums) {
            numsCopy.remove(n);
            for (List<Integer> p : permute(numsCopy)) {
                List<Integer> permutation = new ArrayList<>();
                permutation.add(n);
                permutation.addAll(p);
                result.add(permutation);
            }
            numsCopy.add(n);
        }
        return result;
    }
}
