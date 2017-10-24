// Importance: xx
// do better with 5 lines
// int right = Math.min(C, G);
// int left = Math.min(Math.max(A, E), right);
// int top = Math.min(D, H);
// int bottom = Math.min(Math.max(B, F), top);
// return (A-C)*(B-D) + (E-G)*(F-H) -(right-left)*(top-bottom) ;
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long common = helper(A, C, E, G) * helper(B, D, F, H);
        long r1 = Math.abs(A - C) * Math.abs(B - D);
        long r2 = Math.abs(E - G) * Math.abs(H - F);
        return (int)(r1 + r2 - common);
    }
    private int helper(int A, int C, int E, int G) {
        if (A == C || E == G) return 0;
        if ((A-G) * (long)(C-E) >= 0) return 0;
        else if ((A-E) * (long)(C-G) >= 0) return Math.min(Math.abs(A - G), Math.abs(E - C));
        else return Math.min(C - A, G - E);
    }
}
