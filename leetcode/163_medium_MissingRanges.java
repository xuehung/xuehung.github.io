class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(getRange(lower, upper));
            return result;
        }
        if (nums[0] != lower) result.add(getRange(lower, nums[0] - 1));
        int begin;
        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i - 1] != nums[i] - 1 && nums[i - 1] != nums[i]) {
                result.add(getRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (nums[nums.length - 1] != upper) result.add(getRange(nums[nums.length - 1] + 1, upper));
        return result;

    }
    private String getRange(int a, int b) {
        if (a == b) return String.valueOf(a);
        return String.format("%d->%d", a, b);
    }
}
