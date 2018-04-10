// Importance:xxxx
class Solution {
    int min;
    public int leastInterval(char[] tasks, int n) {
        int[] taskCounter = new int[26];
        for (char c : tasks) taskCounter[c - 'A']++;
        Arrays.sort(taskCounter);
        int idx = 25;
        while (idx >= 0 && taskCounter[idx] == taskCounter[25]) idx--;
        return Math.max(tasks.length, (taskCounter[25] - 1) * (n + 1) + 25 - idx);
    }
}
