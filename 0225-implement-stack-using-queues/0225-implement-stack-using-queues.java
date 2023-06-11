class MyStack {
    
    Queue<Integer> q = new LinkedList<>();
    int top_elem = 0;
    
    public MyStack() {

    }
    
    public void push(int x) {
        // x 是队列的队尾，是栈的栈顶
        q.offer(x);
        top_elem = x;
    }
    
    public int top() {
        
        return top_elem;
    }
    
    public int pop() {
        
        int size = q.size();
        
        //last remain two, first one to record top , second one to poll
        //so act like stack pop out the top element
        
        while( size > 2){
            
        q.offer(q.poll());
        size --;
        }
        
        //new top
        top_elem = q.peek();
        q.offer(q.poll());
        //then poll 
        return q.poll();
        
    }
    

    
    public boolean empty() {
        return q.isEmpty();
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