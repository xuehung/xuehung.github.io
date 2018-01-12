// Importance:xx
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int[] map = new int[26];    
        map['A'-'A'] = 0;
        map['C'-'A'] = 1;
        map['G'-'A'] = 2;
        map['T'-'A'] = 3;
        Set<Integer> occourSet = new HashSet<>();
        Set<Integer> repeatSet = new HashSet<>();
        List<String> result = new ArrayList<>();

        int code = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            code = code << 2;
            code |= map[s.charAt(i) - 'A'];
            if (i >= 9) {
                code &= 0xfffff;
                if (occourSet.contains(code) && !repeatSet.contains(code)) {
                    repeatSet.add(code);
                    result.add(s.substring(i-9, i + 1));
                } else {
                    occourSet.add(code);
                }
            }
        }
        return result;
    }
}
