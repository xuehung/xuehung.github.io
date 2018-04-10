class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for (int n : candies) set.add(n);
        return Math.min(set.size(), candies.length / 2);
    }
}
