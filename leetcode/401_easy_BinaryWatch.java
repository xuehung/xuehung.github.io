public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        List<Integer> h;
        List<Integer> m;
        for (int i = 0 ; i <= num ; i++) {
            h = new ArrayList<>();
            m = new ArrayList<>();
            helper(h, 4, 0, 0, i);
            helper(m, 6, 0, 0, num - i);
            for (int hh : h) {
                for (int mm : m) {
                    if (hh < 12 && mm < 60) {
                        result.add(String.format("%d:%02d", hh, mm));
                    }
                }
            }
        }
        return result;
    }
    public void helper(List<Integer> result, int maxBidPos, int currentBidPos, int currentNum, int remaingBits) {
        if (remaingBits == 0) {
            result.add(currentNum);
        } else if (currentBidPos <= maxBidPos) {
            helper(result, maxBidPos, currentBidPos + 1, currentNum | (1 << currentBidPos), remaingBits - 1);
            helper(result, maxBidPos, currentBidPos + 1, currentNum, remaingBits);
        }
    }
}
