class Solution {
    public int numJewelsInStones(String J, String S) {
        boolean[] isJewel = new boolean[256];
        for (char c : J.toCharArray()) isJewel[c] = true;
        int count = 0;
        for (char c : S.toCharArray()) {
            if (isJewel[c]) count++;
        }
        return count;
    }
}
