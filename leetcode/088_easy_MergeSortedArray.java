// Importance: x
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int sortedPtr = m + n - 1;
        int ptr2 = n - 1;
        int ptr1 = m - 1;
        while (ptr2 >= 0 && ptr1 >=0) {
            nums1[sortedPtr--] = nums2[ptr2] > nums1[ptr1] ? nums2[ptr2--] : nums1[ptr1--];
        }
        while (ptr2 >= 0) {
            nums1[sortedPtr--] = nums2[ptr2--];
        }
    }
}
