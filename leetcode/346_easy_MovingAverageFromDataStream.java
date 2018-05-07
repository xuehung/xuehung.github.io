class MovingAverage {
    int[] arr;
    int idx;
    double sum;
    int n;
    public MovingAverage(int size) {
        arr = new int[size];
        idx = 0;
        sum = 0;
        n = 0;
    }

    public double next(int val) {
        n++;
        sum = sum - arr[idx] + val;
        arr[idx] = val;
        idx++;
        if (idx >= arr.length) idx = 0;
        return sum / Math.min(n, arr.length);
    }
}
