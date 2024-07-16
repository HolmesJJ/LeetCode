class MyQueue {
public:
    stack<int> st1;
    stack<int> st2;

    MyQueue() {
        
    }
    
    void push(int x) {
        st1.push(x);
    }
    
    int pop() {
        if (!st2.empty()) {
            int top = st2.top();
            st2.pop();
            return top;
        }
        while (!st1.empty()) {
            int top = st1.top();
            st1.pop();
            if (st1.empty()) {
                return top;
            }
            st2.push(top);
        }
        return -1;
    }
    
    int peek() {
        if (!st2.empty()) {
            int top = st2.top();
            return top;
        }
        while (!st1.empty()) {
            int top = st1.top();
            st1.pop();
            st2.push(top);
            if (st1.empty()) {
                return top;
            }
        }
        return -1;
    }
    
    bool empty() {
        return st1.size() == 0 && st2.size() == 0;
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */