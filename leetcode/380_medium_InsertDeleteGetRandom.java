class RandomizedSet {

    Map<Integer, Integer> valToIdx;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        valToIdx = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        Integer idx = valToIdx.get(val);
        if (idx == null) {
            valToIdx.put(val, list.size());
            list.add(val);
        }
        return idx == null;
    }

    public boolean remove(int val) {
        Integer idx = valToIdx.get(val);
        if (idx != null) {
            int lastVal = list.get(list.size() - 1);
            list.set(idx, lastVal);
            valToIdx.put(lastVal, idx);
            list.remove(list.size() - 1);
            valToIdx.remove(val);
        }
        return idx != null;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
