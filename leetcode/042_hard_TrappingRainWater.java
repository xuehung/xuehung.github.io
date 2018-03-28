// Importance:xxxx
class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int[] rightMax = new int[height.length];
        for (int i = height.length - 2 ; i >= 0 ; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int sum = 0;
        int leftMax = height[0];
        for (int i = 1 ; i < height.length ; i++) {
            int h = height[i];
            int water = (Math.min(leftMax, rightMax[i]));
            if (water > height[i]) sum += (water - h);
            leftMax = Math.max(h, leftMax);
        }
        return sum;
    }
}

class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int sum = 0;
        int lo = 0, hi = height.length - 1;
        int leftMax = height[lo++], rightMax = height[hi--];
        while (lo <= hi) {
            if (leftMax < rightMax) {
                sum += Math.max(leftMax - height[lo], 0);
                leftMax = Math.max(height[lo], leftMax);
                lo++;
            } else {
                sum += Math.max(rightMax - height[hi], 0);
                rightMax = Math.max(height[hi], rightMax);
                hi--;
            }
        }
        return sum;
    }
}
