class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        int sum = 0;
        int result = 0;
        for (int n : nums) {
            sum += n;
            if (sumMap.containsKey(sum - k)) {
                result += sumMap.get(sum - k);
            }
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
