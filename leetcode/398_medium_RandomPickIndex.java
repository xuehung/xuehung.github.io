// Importance: x
// a better way to select by probability
public class Solution {
    Map<Integer, Integer> countMap = new HashMap<>();
    Map<Integer, Integer> pointerMap = new HashMap<>();
    int[] numsCopy;
    Random rand;
    public Solution(int[] nums) {
        rand = new Random();   
        numsCopy = nums;
        for (int i = 0 ; i < nums.length ; i++) {
            int n = nums[i];
            if (!countMap.containsKey(n)) {
                countMap.put(n, 1);
                pointerMap.put(n, i);
            } else {
                countMap.put(n, countMap.get(n) + 1);
                nums[i] = pointerMap.get(n);
                pointerMap.put(n, i);
            }
        }
    }

    public int pick(int target) {
        int size = countMap.get(target);
        int randomPick = rand.nextInt(size);
        int idx = pointerMap.get(target);
        for (int i = 0 ; i < randomPick ; i++) {
            idx = numsCopy[idx];
        }
        return idx;
    }
}
