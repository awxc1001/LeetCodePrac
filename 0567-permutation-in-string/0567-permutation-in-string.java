class Solution {
    public boolean checkInclusion(String s2, String s1) {
        
        //use hashmap to count each char appearance of s2
        //another hashmap for the sliding window
        Map<Character, Integer> required = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        //populate the required map based on s2
        for(char c: s2.toCharArray()){
            required.put(c,required.getOrDefault(c,0)+1);
        }
        
       //now we move the window based on s1
       int left =0;
       int right =0;
       
       //valid count if the all char in window matched the chars in required(s2) 
       int validCount =0;
        
       //enlarge window till reached the last index
       while(right < s1.length()){
           char c = s1.charAt(right);
           right++;
           //check each char in s1, only update window if char is in s2 required
           if(required.containsKey(c)){
               window.put(c,window.getOrDefault(c,0)+1);
               //update validCount only if charcount in s2 matched the winodw count
               if(required.get(c).equals(window.get(c))){
                   validCount++;
               }
           }
           
           //when enlarging, can simutaneous shrinking the window 
           //when size of the window alredy exceeds the s2 length permutation
           while(right - left >= s2.length()){ 
            //if validCount equals the size of required, meaning it covers all the chars
               if(validCount == required.size()){
                   return true;
               }
             //remove the excess char from window  
               char del = s1.charAt(left);
               left++;
             if(required.containsKey(del)){
                 //if the count matches in both, we need decrease the validCount
                 //meaning window no longer covers all the chars in s2 required
                 if(window.get(del).equals(required.get(del))){
                     validCount --;
                 }
                 window.put(del,window.get(del)-1);
             }  
           }
           
       }
        
      //not found return false
      return false;  
    }
}