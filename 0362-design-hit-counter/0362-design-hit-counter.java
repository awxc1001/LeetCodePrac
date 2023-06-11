class HitCounter {
    
    //counts the number of hits received in the past 5 minutes 
    Queue<Integer> q = new LinkedList<>();

    public HitCounter() {
        
    }
    
    public void hit(int timestamp) {
        q.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        //first in first out, so we can see if it past 300 seconds
        // >= not > 300
        while( !q.isEmpty() && timestamp - q.peek() >= 300){
            //removed all the invalid ones from q
            q.poll();
        }
        //remaining size is the total hits within 5 mins
        return q.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */