class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] counter = new int[10001];
        for (int n : nums) counter[n]++;
        int prev = 0;
        int curr = 0;
        for (int i = 1 ; i < counter.length ; i++) {
            int tmp = curr;
            curr = Math.max(prev + i * counter[i], curr);
            prev = tmp;
        }
        return Math.max(curr, prev);
    }
}
