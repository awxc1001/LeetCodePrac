class Solution {
    public int pivotIndex(int[] nums) {
        
        int[] presum = new int[nums.length+1];
        
        //populate presum
        for(int i =1; i<presum.length; i++){
            presum[i]=presum[i-1]+nums[i-1];
        }
        
        //check for pivot index, start from index 1 of presum
        for(int i =1; i<presum.length; i++){
            //pivot index is excluded from the cacultion 
            //check only left part and right part
            int leftsum = presum[i-1];
            //right sum is total take away the left sum adding the pivtal index
            int rightsum = presum[nums.length]-presum[i];
            
            if(leftsum == rightsum){
                //we shift +1 for the presum 
                return i-1;
            }
        }
        return -1;
    }
}