// Google
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int begin = 0;
        while (begin < nums.length) {
            int end = begin;
            while (end + 1 < nums.length && nums[end + 1] == nums[end] + 1) end++;
            if (begin == end) result.add(String.valueOf(nums[begin]));
            else result.add(nums[begin] + "->" + nums[end]);
            begin = end + 1;
        }
        return result;
    }
}
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        int len = 1;
        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i] == nums[i - 1] + 1) len++;
            else {
                addResult(result, nums[i - 1], len);
                len = 1;
            }
        }
        addResult(result, nums[nums.length - 1], len);
        return result;
    }

    private void addResult(List<String> result, int n, int len) {
        if (len == 1) result.add(String.valueOf(n));
        else result.add((n - len + 1) + "->" + n);
    }
}
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        int begin = 0, end = 0;
        while(++end < nums.length) {
            if (nums[end] == nums[end - 1] + 1) continue;
            else {
                if (begin == end - 1) result.add(String.valueOf(nums[begin]));
                else result.add(String.format("%d->%d", nums[begin], nums[end - 1]));
                begin = end;
            }
        }
        if (begin == end - 1) result.add(String.valueOf(nums[begin]));
        else result.add(String.format("%d->%d", nums[begin], nums[end - 1]));
        return result;
    }
}
