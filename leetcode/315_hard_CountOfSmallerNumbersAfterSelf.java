// Importance:xxxxx
// Google
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int[][] newNums = new int[len][];
        for (int i = 0 ; i < len ; i++) newNums[i] = new int[] {nums[i], i};
        mergeSort(newNums, 0, len - 1, ans);
        List<Integer> result = new ArrayList<>();
        for (int a : ans) result.add(a);
        return result;
    }

    private void mergeSort(int[][] nums, int lo, int hi, int[] ans) {
        if (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            mergeSort(nums, lo, mi, ans);
            mergeSort(nums, mi + 1, hi, ans);
            int i = lo, j = mi + 1;
            int[][] newNums = new int[hi - lo + 1][];
            while (i <= mi && j <= hi) {
                if (nums[i][0] <= nums[j][0]) {
                    ans[nums[i][1]] += (j - mi - 1);
                    newNums[i + j - lo - mi - 1] = nums[i];
                    i++;
                } else {
                    newNums[i + j - lo - mi -1] = nums[j];
                    j++;
                }
            }
            while (i <= mi) {
                newNums[i + j - lo - mi - 1] = nums[i];
                ans[nums[i][1]] += (j - mi - 1);
                i++;
            }
            while (j <= hi) {
                newNums[i + j - lo - mi -1] = nums[j];
                j++;
            }
            for (int k = 0 ; k < newNums.length ; k++) {
                nums[lo + k] = newNums[k];
            }
        }
    }
}
