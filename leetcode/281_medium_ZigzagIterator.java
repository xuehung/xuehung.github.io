// Importance:xxxxx
public class ZigzagIterator {
    Queue<Iterator<Integer>> queue = new LinkedList<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if (!v1.isEmpty()) queue.add(v1.iterator());
        if (!v2.isEmpty()) queue.add(v2.iterator());
    }

    public int next() {
        Iterator<Integer> it = queue.poll();
        int next = it.next();
        if (it.hasNext()) queue.add(it);
        return next;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
