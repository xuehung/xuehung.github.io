// Importance:xxxxx
// Google
class HitCounter {
    private final int N = 300;
    private int[] c;
    private int[] t;
    public HitCounter() {
        c = new int[N];
        t = new int[N];
    }

    public void hit(int timestamp) {
        int idx = timestamp % N;
        if (t[idx] == timestamp) {
            c[idx]++;
        } else {
            t[idx] = timestamp;
            c[idx] = 1;
        }
    }

    public int getHits(int timestamp) {
        int lowerBound = timestamp - N;
        int sum = 0;
        for (int i = 0 ; i < N ; i++) {
            if (t[i] > lowerBound) sum += c[i];
        }
        return sum;
    }
}
