class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0 || nums.length == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0 ; i < nums.length ; i++) {
            int n = nums[i];
            while (!deque.isEmpty() && deque.peekLast() < n) deque.removeLast();
            deque.addLast(n);
            if (i >= k && nums[i - k] == deque.peekFirst()) deque.removeFirst();
            if (i >= k - 1) result[i - k + 1] = deque.peekFirst();
        }
        return result;
    }
}
