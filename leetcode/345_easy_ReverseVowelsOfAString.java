// Google
public class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder sb = new StringBuilder();
        int lo = -1, hi = s.length();
        char[] carr = s.toCharArray();
        while (++lo < --hi) {
            while (lo < carr.length && !vowels.contains(carr[lo])) lo++;
            while (hi > 0 && !vowels.contains(carr[hi])) hi--;
            if (lo < hi) {
                char tmp = carr[lo];
                carr[lo] = carr[hi];
                carr[hi] = tmp;
            }
        }
        for (char c : carr) sb.append(c);
        return sb.toString();
    }
}
public class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder sb = new StringBuilder();
        int vowelPointer = s.length() - 1;
        int nonVowelPointer = 0;
        while (nonVowelPointer < s.length()) {
            char c = s.charAt(nonVowelPointer);
            if (!vowels.contains(c)) {
                sb.append(c);
            } else {
                while (vowelPointer >= 0 && !vowels.contains(s.charAt(vowelPointer))) {
                    vowelPointer--;
                }
                if (vowelPointer >= 0) {
                    sb.append(s.charAt(vowelPointer--));
                }
            }
            nonVowelPointer++;
        }
        return sb.toString();
    }
}
