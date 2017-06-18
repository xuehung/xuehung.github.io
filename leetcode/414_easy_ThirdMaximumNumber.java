public class Solution {
    public int thirdMax(int[] nums) {
        List<Integer> queue = new LinkedList<>();
        int min = Integer.MIN_VALUE;
        for (int n : nums) {
            if (queue.isEmpty()) queue.add(n);
            else if (queue.contains(n)) continue;
            else if (n >= min) queue.add(n);
            if (queue.size() > 3) {
                Collections.sort(queue);
                queue.remove(0);
                min = queue.get(0);
            }
        }
        Collections.sort(queue);
        return queue.size() < 3 ? queue.get(queue.size() - 1) : queue.get(0);
    }
}
