class Solution {
    String[] mapping = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String word : words) {
            String code = "";
            for (char c : word.toCharArray()) {
                code += mapping[c - 'a'];
            }
            set.add(code);
        }
        return set.size();
    }
}
