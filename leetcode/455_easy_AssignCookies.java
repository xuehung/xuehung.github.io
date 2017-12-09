class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int size = 0;
        int gPtr = 0, sPtr = 0;
        while (gPtr < g.length && sPtr < s.length) {
            if (g[gPtr] <= s[sPtr]) {
                size++;
                gPtr++;
            }
            sPtr++;
        }
        return size;
    }
}
