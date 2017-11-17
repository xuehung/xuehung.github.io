class MyQueue {

    Stack<Integer> pushStack = null;
    Stack<Integer> popStack = null;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack  = new Stack<>();
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if (popStack.isEmpty()) _moveToPop();
        return popStack.pop();
    }

    public int peek() {
        if (popStack.isEmpty()) _moveToPop();
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

    private void _moveToPop() {
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
    }
}
