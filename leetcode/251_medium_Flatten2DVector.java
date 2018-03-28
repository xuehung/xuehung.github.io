public class Vector2D implements Iterator<Integer> {

    List<List<Integer>> list;
    int i = 0, j = 0;
    int value = 0;
    public Vector2D(List<List<Integer>> vec2d) {
        list = vec2d;
    }

    @Override
    public Integer next() {
        return value;
    }

    @Override
    public boolean hasNext() {
        while (i < list.size()) {
            List<Integer> inner = list.get(i);
            if (j < inner.size()) {
                value = inner.get(j++);
                return true;
            }
            i++;
            j = 0;
        }
        return false;
    }
}
