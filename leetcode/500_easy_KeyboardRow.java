public class Solution {
    public String[] findWords(String[] words) {
        int[] mapping = new int[26];
        mapping['a' - 'a'] = 2;
        mapping['s' - 'a'] = 2;
        mapping['d' - 'a'] = 2;
        mapping['f' - 'a'] = 2;
        mapping['g' - 'a'] = 2;
        mapping['h' - 'a'] = 2;
        mapping['j' - 'a'] = 2;
        mapping['k' - 'a'] = 2;
        mapping['l' - 'a'] = 2;
        mapping['z' - 'a'] = 3;
        mapping['x' - 'a'] = 3;
        mapping['c' - 'a'] = 3;
        mapping['v' - 'a'] = 3;
        mapping['b' - 'a'] = 3;
        mapping['n' - 'a'] = 3;
        mapping['m' - 'a'] = 3;
        List<String> result = new ArrayList<>();
        for (String word : words) {
            String sword = word.toLowerCase();
            boolean okay = true;
            for (int i = 1 ; i < sword.length() ; i++) {
                if (mapping[sword.charAt(i - 1) - 'a'] != mapping[sword.charAt(i) - 'a']) {
                    okay = false;
                    break;
                }
            }
            if (okay) result.add(word);
        }
        String[] output = new String[result.size()];
        for (int i = 0 ; i < output.length ; i++) output[i] = result.get(i);
        return output;
    }
}
