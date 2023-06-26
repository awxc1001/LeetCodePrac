class Solution {
    public int longestOnes(int[] nums, int k) {
        
        //keep a valid window by only allowing k 0s
        // if k =2, then 1,0,0 is the maximum condition
        
        int left =0;
        int right=0;
        
        //this is a zeroCount for the sliding window
        int zeroCount =0;
        int maxLen = Integer.MIN_VALUE;
        while(right < nums.length){
            
            if(nums[right] == 0){
                zeroCount++;
            }
            
            right++;
            
            //if now window is 10010, need to remove the zeroCount to 2 if k=2
            while( zeroCount> k ){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
           //as long zeroCount is valid, return the maxinum number of 
            maxLen = Math.max(maxLen, right-left);
            
        }
        
        return maxLen;
    }
}