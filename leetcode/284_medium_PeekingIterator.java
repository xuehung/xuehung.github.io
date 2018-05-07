class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer val = null;
    boolean hasNext = false;
    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator =iterator iterator;
        if (iterator.hasNext()) {
            hasNext = true;
            val = iterator.next();
        }
    }

    public Integer peek() {
        return val;
    }

    @Override
    public Integer next() {
        Integer returnet = val;
        if (iterator.hasNext()) {
            hasNext = true;
            val = iterator.next();
        } else {
            hasNext = false;
        }
        return ret;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }
}hasNext
