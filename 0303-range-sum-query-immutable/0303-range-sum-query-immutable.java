class NumArray {
    
    public int[] preSum; // bunch of zeros

    public NumArray(int[] nums) {
        //accumulate presum size is len+1
        preSum = new int[nums.length + 1];  
        //accumulate all the sum from nums to presum
        for( int i =1; i< preSum.length; i++){
            preSum[i] = preSum[i-1]+nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        //preSum start with 0, so right+1
        return preSum[right+1] - preSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */