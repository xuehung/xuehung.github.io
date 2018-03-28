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
