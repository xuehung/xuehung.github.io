// Importance: xxxxx
// Amazon
class Solution {
    int left = 0;
    int right = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        for (int i = 0 ; i < s.length() ; i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return s.substring(left, right + 1);
    }

    private void helper(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        if (j - i - 2 > right - left) {
            left = i + 1;
            right = j - 1;
        }
    }
}
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int longest = 0;
        List<String> strList = new ArrayList();
        for (char c : s.toCharArray()) strList.add(String.valueOf(c));
        s = String.join(",", strList);
        String output = String.valueOf(s.charAt(0));
        int len = s.length();
        for (int i = 0 ; i < len ; i++) {
            int currentLen = 1;
            int left = i, right = i;
            while (--left >= 0 && ++right < len) {
                char leftChar = s.charAt(left), rightChar = s.charAt(right); 
                if (leftChar == rightChar) {
                    currentLen += 2;
                    if (rightChar != ',') {
                        int palindromeLen = (currentLen / 2) + 1;
                        if (palindromeLen > longest) {
                            output = s.substring(left, right + 1);
                            longest = palindromeLen;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return output.replace(",", "");
    }
}



public class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }
}
