class MovingAverage {
    
    Queue<Integer> q = new LinkedList<>();
    int size = 0;
    // to calculate based on all elements in queue, we need a class variable
    double sum = 0;

    public MovingAverage(int size) {
        this.size = size;
    }
    
    public double next(int val) {
        q.offer(val);
        sum += val;
        //if too many reduce the q size to max size
        while( q.size() > size ){
             int invalid = q.poll();
             sum -= invalid;   
        }
        
        //then do the calculating average
        return sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */