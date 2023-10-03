    //design 单调栈
class MonotonicQueue {
    LinkedList<Integer> q = new LinkedList<>();
    
    public void offer(int n){
        //保证新元素一直在队尾而且最小，所以要把队列里任何比他小的都删了，直到空为止
        while(!q.isEmpty() && n > q.getLast()){
            q.pollLast();
        }
        q.addLast(n);
    }
    
    public int getMax(){
        //最大值会一直保证在头部
        return q.getFirst();
    }
    
    //因为可能之前插入的时候就已经把元素移除了
    //当滑动窗口向右移动时，窗口的最左侧的元素即将离开窗口。我们需要检查这个即将离开窗口的元素是否是当前的最大值，也就是单调队列的头部元素。

    // 如果它是队首元素，那么当它离开窗口，这个最大值就不再属于当前窗口，所以需要从队列中移除。

    // 如果它不是队首元素，那么这个数在之前已经被其他更大的数从队列中挤出去了，因此即使它离开窗口，也不影响窗口的最大值。

    // 综上，我们只需要关心窗口最左侧的元素是否是队首元素。如果是，我们就移除队首元素；如果不是，我们不做任何操作。
    public void poll(int n){
        if(q.getFirst() == n){
            q.pollFirst();
        }
    }

}

class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue q = new MonotonicQueue();
        ArrayList<Integer> result = new ArrayList<>();
        
        //sliding window using the q
        //do the first k elements first
        for(int i = 0; i < k; i++){
            q.offer(nums[i]);
        }
        //now record the max
        result.add(q.getMax());
        
        //now we can finish the rest of the elements
        for(int i = k; i < nums.length; i++){
            //移除最老的，加入最新的
            q.poll(nums[i-k]);
            q.offer(nums[i]);
            //记录最大值
            result.add(q.getMax());
        
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}