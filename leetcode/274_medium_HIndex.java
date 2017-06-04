// Importance: x
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int size = citations.length;
        int h = 0;
        for (int i = 0 ; i < size ; i++) {
            int candidateH = size - i;
            if (citations[i] >= candidateH) {
                if (i == 0 || (i > 0 && citations[i - 1] <= candidateH)) {
                    h = Math.max(candidateH, h);
                }
            }
        }
        return h;
    }
}
