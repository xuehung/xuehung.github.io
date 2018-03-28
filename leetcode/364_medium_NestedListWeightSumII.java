class Solution {
    int depth = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        _dfs(nestedList, 0);
        return _helper(nestedList, depth);
    }

    private void _dfs(List<NestedInteger> nestedList, int level) {
        level++;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) depth = Math.max(depth, level);
            else _dfs(ni.getList(), level);
        }
    }

    private int _helper(List<NestedInteger> nestedList, int level) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) sum += (ni.getInteger() * level); 
            else sum += _helper(ni.getList(), level - 1);
        }
        return sum;
    }
}
