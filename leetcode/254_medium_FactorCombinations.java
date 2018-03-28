class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        _helper(n, n, new ArrayList<>(), result);
        return result;
    }

    private void _helper(int n, int target, List<Integer> current, List<List<Integer>> result) {
        if (!current.isEmpty()) {
            if (current.get(current.size() - 1) > target) return;
            current.add(target);
            result.add(new ArrayList<>(current));
            current.remove(current.size() - 1);
        }
        for (int i = current.isEmpty() ? 2 : current.get(current.size() - 1) ; i < target ; i++ ) {
            if (target % i == 0) {
                current.add(i);
                _helper(n, target / i, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
