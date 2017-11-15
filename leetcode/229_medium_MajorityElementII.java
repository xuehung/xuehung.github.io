// Importance:x
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n1 = 0, n2 = 0;
        int count1 = 0, count2 = 0;
        for (int n : nums) {
            if (n == n1) count1++;
            else if (n == n2) count2++;
            else if (count1 == 0) {
                n1 = n;
                count1++;
            } else if (count2 == 0) {
                n2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int n : nums) {
            if (n == n1) count1++;
            else if (n == n2) count2++;
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) result.add(n1);
        if (count2 > nums.length / 3) result.add(n2);
        return result;
    }
}
