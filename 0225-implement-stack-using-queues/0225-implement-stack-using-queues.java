class MyStack {
    
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top = -1;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    public void push(int x) {
        queue1.add(x);
        top = x;
    }
    
    public int pop() {
        if (!queue1.isEmpty()) {
            while (queue1.size() > 1) {
                top = queue1.poll();
                queue2.add(top);
            }
            return queue1.poll();
        } else if (!queue2.isEmpty()) {
            while (queue2.size() > 1) {
                top = queue2.poll();
                queue1.add(top);
            }
            return queue2.poll();
        } else {
            return -1;
        }
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */