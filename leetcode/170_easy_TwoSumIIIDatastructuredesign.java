class TwoSum {

    Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (Integer key : map.keySet()) {
            int target = value - key;
            if (target == key && map.get(key) > 1) return true;
            else if (target != key && map.containsKey(target)) return true;
        }
        return false;
    }
}
