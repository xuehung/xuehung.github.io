class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0, b = (int)Math.sqrt(c);
        int aa = a * a;
        int bb = b * b;
        while (a <= b) {  
            int sum = aa + bb;
            if (sum == c) return true;
            else if (sum < c) {
                a++;
                aa = a * a;
            } else {
                b--;
                bb = b*b;
            }
        }
        return false;
    }
}
