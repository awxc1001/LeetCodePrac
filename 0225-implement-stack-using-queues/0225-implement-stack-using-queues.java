class MyStack {
    //q1 1x 2y 3z add g, first poll out into q2 1x 2y 3z, then q1 add g      
    // //在加入元素时先将q1中的元素依次出栈压入q2，然后将新加入的元素压入q1，再将q2中的元素依次出栈压入q1
    Queue<Integer> q1,q2; 
    
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        while(q1.size() > 0){
            q2.offer(q1.poll());
        }
        
        q1.offer(x);
        
        while(q2.size() > 0){
            q1.offer(q2.poll());
        }
        
    }
    //since push reset the order, rest is simple operation
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
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