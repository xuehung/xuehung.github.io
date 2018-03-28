class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0 ; i < B.length ; i++) {
            int n = B[i];
            map.computeIfAbsent(n, k -> new LinkedList<>()).add(i);
        }
        int[] result = new int[A.length];
        for (int i = 0 ; i < A.length ; i++) {
            int n = A[i];
            result[i] = map.get(n).poll();
        }
        return result;
    }
}
