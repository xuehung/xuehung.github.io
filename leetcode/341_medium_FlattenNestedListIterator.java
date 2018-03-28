// Importance:xxx
ipublic class NestedIterator implements Iterator<Integer> {

    Stack<List<NestedInteger>> stackList;
    Stack<Integer> stackInt;
    Integer value;

    public NestedIterator(List<NestedInteger> nestedList) {
        stackList = new Stack<>();
        stackInt = new Stack<>();
        stackList.push(null);
        stackList.push(nestedList);
        stackInt.push(0);
        stackInt.push(0);
    }

    @Override
    public Integer next() {
        return value;
    }

    @Override
    public boolean hasNext() {
        if (stackList.isEmpty()) return false;
        List<NestedInteger> list = stackList.pop();
        int idx = stackInt.pop();
        while(list != null) {
            if (idx >= list.size()) {
                list = stackList.pop();
                idx = stackInt.pop();
            } else if (list.get(idx).isInteger()) {
                value = list.get(idx).getInteger();
                stackList.push(list);
                stackInt.push(idx + 1);
                return true;
            } else {
                stackList.push(list);
                list = list.get(idx).getList();
                stackInt.push(idx + 1);
                idx = 0;
            }
        }
        return false;
    }
}
