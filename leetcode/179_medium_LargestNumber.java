// Importance:xxxx
class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int n : nums) list.add(String.valueOf(n));
        Collections.sort(list, (a, b) -> {
            return compare(a, b);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1 ; i >= 0 ; i--) sb.append(list.get(i));
        String output = sb.toString();
        return output.charAt(0) == '0' ? "0" : output;
    }

    private int compare(String s1, String s2) {
        if (s1.equals(s2)) return 0;
        int commonLen = Math.min(s1.length(), s2.length());
        int d = s1.substring(0, commonLen).compareTo(s2.substring(0, commonLen));
        if (d != 0) return d;
        if (s1.length() <= commonLen) return compare(s1, s2.substring(commonLen));
        return compare(s1.substring(commonLen), s2);
    }
}
