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
