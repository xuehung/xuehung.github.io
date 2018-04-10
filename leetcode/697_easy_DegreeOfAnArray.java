class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> smallIdx = new HashMap<>();
        Map<Integer, Integer> largeIdx = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            int n = nums[i];
            freq.put(n, freq.getOrDefault(n, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(n));
            if (!smallIdx.containsKey(n)) smallIdx.put(n, i);
            largeIdx.put(n, i);
        }
        int output = nums.length;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int n = e.getKey();
            if (e.getValue() == maxFreq) {
                output = Math.min(output, largeIdx.get(n) - smallIdx.get(n) + 1);
            }
        }
        return output;
    }
}
