// Importance:xx
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int begin = 0;
        int tank = 0;
        int idx = begin;
        while (idx < gas.length) {
            tank += (gas[idx] - cost[idx]);
            idx++;
            if (tank < 0) {
                begin = idx;
                tank = 0;
            }
        }
        if (begin == 0) return begin;
        if (begin == gas.length) return -1;
        idx = 0;
        while (idx < begin) {
            tank += (gas[idx] - cost[idx]);
            idx++;
            if (tank < 0) return -1;
        }
        return begin;
    }
}
