class Solution {
    public int minOperations(int[] nums, int x) {
        
        //find the longest subarray of nums after deduct x
        int sum =0;
        for(int i:nums){
            sum += i;
        }
       
       //two pointers for the window
       int left = 0;
       int right = 0;
       int windowSum =0; 
        
       //target leftover after remove x
       int target = sum - x;    
       //record the longest subarray, if not found keep it min 
       int maxLen = Integer.MIN_VALUE;
        
       while(right < nums.length){
           //enlarge window 
           int num = nums[right];
           right++;
           windowSum+=num;
           
           //if exceeds target, shrink window, fill more numbers
           while(windowSum > target && left < right){
               int del = nums[left];
               left++;
               windowSum -= del;
           }
          //look for a valid answer, record the max one
          if(windowSum == target){
              maxLen = Math.max(maxLen, right-left);
          } 
       } 
       
       return maxLen == Integer.MIN_VALUE ? -1:nums.length-maxLen; 
    }
}