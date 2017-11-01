class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counter = new int[256];
        for (char c : ransomNote.toCharArray()) counter[c]++;
        for (char c : magazine.toCharArray()) counter[c]--;
        for (int n : counter) {
            if (n > 0) return false;
        }
        return true;
    }
}
