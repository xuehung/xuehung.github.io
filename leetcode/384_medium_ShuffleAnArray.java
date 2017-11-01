// Importance: x
class Solution {
    int[] origin;
    Random r = new Random();
    public Solution(int[] nums) {
        origin = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffled = new int[origin.length];
        System.arraycopy( origin, 0, shuffled, 0, shuffled.length);
        for (int i = shuffled.length - 1 ; i > 0 ; i--) {
            int indexToSwap = r.nextInt(i + 1);
            int tmp = shuffled[indexToSwap];
            shuffled[indexToSwap] = shuffled[i];
            shuffled[i] = tmp;
        }
        return shuffled;
    }
}
