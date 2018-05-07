class Solution {
    public String frequencySort(String s) {
        int[] counter = new int[256];
        List<int[]> list = new ArrayList<>();
        for (char c : s.toCharArray()) counter[c]++;
        for (int i = 0 ; i < counter.length ; i++) {
            if (counter[i] > 0) list.add(new int[] {i, counter[i]} );
        }
        Collections.sort(list, (a, b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            return b[1] - a[1];
        });
        StringBuilder sb = new StringBuilder();
        for (int[] e : list) {
            while (e[1]-- > 0) {
                sb.append((char)(e[0]));
            }
        }
        return sb.toString();
    }
}
