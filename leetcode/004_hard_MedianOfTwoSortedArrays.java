// Importance:xxxxxx
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        return (kth(nums1, nums2, 0, 0, (n + m - 1) / 2) + kth(nums1, nums2, 0, 0, (n + m) / 2)) / 2.0;
    }

    private int kth(int[] nums1, int[] nums2, int begin1, int begin2, int k) {
        if (begin1 >= nums1.length) return nums2[begin2 + k];
        if (begin2 >= nums2.length) return nums1[begin1 + k];
        if (k == 0) return Math.min(nums1[begin1], nums2[begin2]);
        int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
        int half = (k + 1) / 2;
        if (begin1 + half - 1 < nums1.length) m1 = nums1[begin1 + half - 1];
        if (begin2 + half - 1 < nums2.length) m2 = nums2[begin2 + half - 1];
        if (m1 < m2) return kth(nums1, nums2, begin1 + half, begin2, k - half);
        else return kth(nums1, nums2, begin1, begin2 + half, k - half);
    }
}
