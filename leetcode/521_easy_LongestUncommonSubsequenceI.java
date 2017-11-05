class Solution {
    public int findLUSlength(String a, String b) {
        int lenA = a.length(), lenB = b.length();
        if (lenA != lenB) return Math.max(lenA, lenB);
        int left = 0, right = lenA - 1;
        int answer = lenA;
        while (answer > 0) {
            boolean leftEqual = a.charAt(left) == b.charAt(left);
            boolean rightEqual = a.charAt(right) == b.charAt(right);
            if (!leftEqual || !rightEqual) return answer;
            if (leftEqual) {
                left++;
                answer--;
            }
            if (rightEqual) {
                right--;
                answer--;
            }
        }
        return -1;
    }
}
