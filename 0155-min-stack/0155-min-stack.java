class MinStack {
    
    //use two stacks
    // 记录栈中的所有元素
    Stack<Integer> stk = new Stack<>();
    // 阶段性记录栈中的最小元素
    Stack<Integer> minStk = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        
        stk.push(val);
        //minStack will push the smallest repeated or update to it
        //dont forget if empty minStk just push it like a normal stack
        if( minStk.isEmpty() || val < minStk.peek()){
            minStk.push(val);
        }else{
            minStk.push(minStk.peek());
        }
    }
    
    public void pop() {
        stk.pop();
        minStk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minStk.peek();
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