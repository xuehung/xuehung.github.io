class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    public int helper(List<NestedInteger> nestedList, int d) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) sum += (d * ni.getInteger());
            else sum += helper(ni.getList(), d + 1);
        }
        return sum;
    }
}
