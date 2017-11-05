class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counter = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int n : nums1) counter.put(n, counter.getOrDefault(n, 0) + 1);
        for (int n : nums2) {
            if (counter.containsKey(n)) {
                result.add(n);
                if (counter.get(n) == 1) {
                    counter.remove(n);
                } else {
                    counter.put(n, counter.get(n) - 1);
                }
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0 ; i < result.size() ; i++) arr[i] = result.get(i);
        return arr;
    }
}
