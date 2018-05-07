class Solution {
    public List<Integer> partitionLabels(String S) {
        int len = S.length();
        int[] maxIdx = new int[256];
        for (int i = len - 1 ; i >= 0 ; i--) {
            int idx = S.charAt(i) - 'a';
            if(maxIdx[idx] == 0) maxIdx[idx] = i;
        }
        List<Integer> output = new ArrayList<>();
        int rightMost = 0;
        int total = 0;
        for (int i = 0 ; i < len ; i++) {
            rightMost = Math.max(rightMost, maxIdx[S.charAt(i) - 'a']);
            if (rightMost == i) {
                if (output.isEmpty()) output.add(i + 1);
                else output.add(i + 1 - total);
                total += output.get(output.size() - 1);
            }
        }
        return output;
    }
}
