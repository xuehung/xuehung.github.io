// Importance: x
/*
 * first version
 */
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> sol = new HashMap<>();
        for (int i = nums.length - 1 ; i >= 0 ; i--) {
            int nextGreaterIdx = -1;
            int checkIdx = i + 1;
            while (checkIdx >= 0 && checkIdx < nums.length) {
                if (nums[checkIdx] > nums[i]) {
                    nextGreaterIdx = checkIdx;
                    break;
                } else {
                    checkIdx = sol.get(nums[checkIdx]);
                }
            }
            sol.put(nums[i], nextGreaterIdx);
        }
        for (int i = 0 ; i < findNums.length ; i++) {
            int nextIdx = sol.get(findNums[i]);
            findNums[i] = nextIdx == -1 ? nextIdx : nums[nextIdx];
        }
        return findNums;
    }
}
/* 
 * better version 
 * https://discuss.leetcode.com/topic/77916/java-10-lines-linear-time-complexity-o-n-with-explanation/6
 */
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> sol = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int n : nums) {
            while (!stack.isEmpty() && stack.peek() < n) {
                sol.put(stack.pop(), n);
            }
            stack.push(n);
        }
        for (int i = 0 ; i < findNums.length ; i++) {
            findNums[i] = sol.containsKey(findNums[i]) ? sol.get(findNums[i]) : -1;
        }
        return findNums;
    }
}
