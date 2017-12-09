// Importance:xxx
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[][] ans = new int[n][2];
        Arrays.sort(people, (p1, p2) -> p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) list.add(p[1], p);

        for (int i = 0 ; i < list.size() ; i++) {
            int[] p = list.get(i);
            ans[i][0] = p[0];
            ans[i][1] = p[1];
        }

        return ans;
    }
}
