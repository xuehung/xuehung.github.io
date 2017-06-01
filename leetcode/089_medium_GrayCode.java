// Importance: x
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0 ; i < n ; i++) {
            for (int j = result.size() - 1 ; j >= 0 ; j--) {
                int bitMask = 1 << i;
                result.add(result.get(j) | bitMask);
            }
        }
        return result;
    }
}
