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
