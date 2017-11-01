class Solution {
    public int firstUniqChar(String s) {
        int[] counter = new int[256];
        for (char c : s.toCharArray()) {
            counter[c]++;
        }
        int i = -1;
        int answer = -1;
        for (char c : s.toCharArray()) {
            i++;
            if (counter[c] == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
