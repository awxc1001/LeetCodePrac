class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        int left = 0;
        int right = 0;
        //nums[i] == nums[j] and abs(i - j) <= k
        //this means the subarray size cant be over than K
        //our window needs to be within k
        
         //hashmap record the counts of each
         Map<Integer,Integer> numbers = new HashMap<>();
        // for(int i:nums){
        //     numbers.put(i,numbers.getOrDefault(i,0)+1);
        // }
        
        while(right < nums.length){
            
            //enlarging while recording the count
            if(right-left <=k){
               int num = nums[right]; 
               //while we check if this num already been recorded
               if(numbers.containsKey(num)&&!numbers.get(num).equals(0)){
                   return true;
               } 
               numbers.put(num,numbers.getOrDefault(num,0)+1);         
               right++;
            }
           //shrink the window if it is out of boundray
           while(right-left >k){
               int del = nums[left];
               left++;
               numbers.put(del,numbers.get(del)-1);
           } 
        }
        
        return false;
    }
}