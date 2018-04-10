// Importance:xxxx
class Solution {
    public List<String> addOperators(String num, int target) {
        int[] nums = new int[num.length()];
        for (int i = 0 ; i < num.length() ; i++) nums[i] = num.charAt(i) - '0';
        List<String> result = new ArrayList();
        _helper(0, target, 0, "", 0, nums, result);
        return result;
    }

    private void _helper(long sum, long target, long prev, String path, int idx, int[] nums, List<String> result) {
        if (idx >= nums.length) {
            if (sum == target) {
                result.add(path);
            }
        } else {
            int end = idx;
            long val = 0;
            while (end < nums.length) {
                val = val * 10 + nums[end];
                if (val > 3000000000L) break;
                if (idx == 0) {
                    _helper(val, target, val, val + "", end + 1, nums, result);
                } else {
                    _helper(sum + val, target, val, path + "+" + val, end + 1, nums, result);
                    _helper(sum - val, target, -val, path + "-" + val, end + 1, nums, result);
                    _helper(sum - prev + prev * val, target, prev * val, path + "*" + val, end + 1, nums, result);
                }
                if (end == idx && val == 0) break;
                end++;
            }
        }
    }
}
