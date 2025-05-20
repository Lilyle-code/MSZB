class MinStack {
    private Deque<Integer> min_stack;
    private Deque<Integer> stack;

    public MinStack() {
        min_stack = new ArrayDeque<>();
        stack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if(min_stack.isEmpty() || val <= min_stack.peek()) min_stack.push(val);
    }

    public void pop() {
        int val = stack.pop();
        if(val == min_stack.peek()) min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min_stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */