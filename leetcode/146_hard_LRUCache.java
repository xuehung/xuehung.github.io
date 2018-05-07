class LRUCache {
    class Node {
        Node prev;
        Node next;
        int value;
    }
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Integer> map;
    Map<Integer, Node> nodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        nodeMap = new HashMap<>();
        head = new Node();
        tail = head;
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (value == null) return -1;
        refresh(key);
        return value;
    }

    public void put(int key, int value) {
        Integer val = map.get(key);
        if (val != null) {
            refresh(key);
            map.put(key, value);
            return;
        }
        if (map.size() == capacity) {
            nodeMap.remove(tail.value);
            map.remove(tail.value);
            tail = tail.prev;
            tail.next = null;
        }
        Node newNode = new Node();
        newNode.value = key;
        addToHead(newNode);
        nodeMap.put(key, newNode);
        map.put(key, value);
    }

    private void remove(Node node) {
        if (node == null) return;
        if (node == tail) tail = node.prev;
        node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        if (node == null) return;
        node.next = head.next;
        if (node.next != null) node.next.prev = node;
        node.prev = head;
        head.next = node;
        if (head == tail) tail = head.next;
    }

    private void refresh(int key) {
        Node node = nodeMap.get(key);
        remove(node);
        addToHead(node);
    }
}
class LRUCache {

    Map<Integer, Integer> cache;
    int capacity;
    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        return refresh(key) ? cache.get(key) : -1;
    }

    public void put(int key, int value) {
        if (!refresh(key)) {
            if (cache.size() == capacity) {
                cache.remove(cache.keySet().iterator().next());
            }
        }
        cache.put(key, value);
    }

    private boolean refresh(int key) {

        Integer val = cache.get(key);
        if (val != null) {
            cache.remove(key);
            cache.put(key, val);
        }
        return val != null;
    }
}
