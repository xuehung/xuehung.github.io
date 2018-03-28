// Importance:x
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> counter1 = countHelper(A, B);
        Map<Integer, Integer> counter2 = countHelper(C, D);
        for (int i : counter1.keySet()) {
            int count = counter2.getOrDefault(-i, 0);
            result += (count * counter1.get(i));
        }
        return result;
    }

    private Map<Integer, Integer> countHelper(int[] m, int[] n) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i : m) {
            for (int j : n) {
                int sum = i + j;
                counter.put(sum, counter.getOrDefault(sum, 0) + 1);
            }
        }
        return counter;
    }
}
