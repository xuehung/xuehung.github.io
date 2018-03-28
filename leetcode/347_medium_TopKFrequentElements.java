// Importance:x
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> freqToList = new HashMap<>();
        for (int n : nums) counter.put(n, counter.getOrDefault(n, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            pq.add(-entry.getValue());
            freqToList.computeIfAbsent(entry.getValue(), key -> new ArrayList<>()).add(entry.getKey());
        }
        for (int i = 0 ; i < k ;) {
            List<Integer> toAdd = freqToList.get(-pq.poll());
            result.addAll(toAdd);
            i += toAdd.size();
            for (int j = 1 ; j < toAdd.size() ; j++) pq.poll();
        }
        return result;
    }
}
