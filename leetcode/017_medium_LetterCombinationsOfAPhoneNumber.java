// Google
class Solution {
    public List<String> letterCombinations(String digits) {
        int[] mappingBegin = new int[] {0, 0, 0, 3, 6, 9, 12, 15, 19, 22, 26};
        List<String> result = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            int idx = c - '0';
            int begin = mappingBegin[idx];
            int len = mappingBegin[idx + 1] - mappingBegin[idx];
            if (result.size() == 0) {
                for (int i = 0 ; i < len ; i++) result.add(String.valueOf((char)('a' + begin + i)));
            } else {
                List<String> newResult = new ArrayList<>();
                for (int i = 0 ; i < len ; i++) {
                    for (String s : result) newResult.add(s + (char)('a' + begin + i));
                }
                result = newResult;
            }
        }
        return result;
    }
}
