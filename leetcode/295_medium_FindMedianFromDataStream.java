// Importance:xxx
class MedianFinder {

    private PriorityQueue<Long> minPq = new PriorityQueue<>();
    private PriorityQueue<Long> maxPq = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        maxPq.add((long)num);
        minPq.add(-maxPq.poll());
        if (minPq.size() > maxPq.size()) {
            maxPq.add(-minPq.poll());
        }
    }

    public double findMedian() {
        if (maxPq.size() > minPq.size()) return maxPq.peek();
        return (-minPq.peek() + maxPq.peek()) / 2.0;
    }
}
