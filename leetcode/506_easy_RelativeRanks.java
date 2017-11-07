class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] out = new String[nums.length];
        Map<Integer, List<Integer>> mapping = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0 ; i < nums.length ; i++) {
            int n = nums[i];
            if (!mapping.containsKey(n)) {
                mapping.put(n, new ArrayList<>());
                pq.add(-n);
            }
            mapping.get(n).add(i);
        }
        int rank = 1;
        while (!pq.isEmpty()) {
            int n =-pq.poll();
            String s = String.valueOf(rank);
            if (rank == 1) s = "Gold Medal";
            else if (rank == 2) s = "Silver Medal";
            else if (rank == 3) s = "Bronze Medal";
            for (int idx : mapping.get(n)) {
                out[idx] = s;
            }
            rank++;
        }
        return out;
    }
}
