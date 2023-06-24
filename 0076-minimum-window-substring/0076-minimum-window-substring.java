class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> require = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        
        //pop up the require map with the String t chars, so it holds all the counts
        //of unique char
        for(char c: t.toCharArray()){
            require.put(c, require.getOrDefault(c,0)+1);
        }
        
        //pointers for the sliding window
        
        int left = 0;
        int right = 0;
        
        //record the valid count for each char in both hashmap
        int validCount =0;
        
        //going for minimum length of a substring
        int start = 0; //starting index of the substring
        int len = Integer.MAX_VALUE;
        
        while(right < s.length()){
            //moving the window and update the window Map
            char c = s.charAt(right);
            right ++;
            //update the data in map
            if(require.containsKey(c)){
        //s="AAABBC"，t="ABC"，那么require映射就是{A:1, B:1, C:1}。
        //在while循环中，我们扩大窗口，然后window映射变成{A:3, B:2, C:1}，同时validCount也达到了require.size()（为3）。
                window.put(c, window.getOrDefault(c,0)+1);
                //if each key value pair match, update the validCount
                if(window.get(c).equals(require.get(c))){
                    validCount++;
                }
            }
            
         //shrink the window only if valid covers all the require charcters
         while(validCount == require.size()){
             //now validCount covers all the elements in require
             //now update the minimun length subString
             if(right - left < len){
                 start = left;
                 len = right - left;
             }
             //remove the char out of the window, and also only update the valid
             // and the window if the removed char is one of the matched ones in require
             char del = s.charAt(left);
             left++;
             
             //update the window only if the del key is in the require map
             if(require.containsKey(del)){
                 //window映射{A:3, B:2, C:1}
                 //only update validCount matched both map, so no more shrink
                 //require映射{A:1, B:1, C:1}
                 if(window.get(del).equals(require.get(del))){
                     validCount--;          
                 }
            // keep removing from the window regardless,
            window.put(del, window.get(del)-1); 
            }
             
 
             
         }   
        }
        
        //either didnt find, or return the smallest subString with the start and len
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        
    }
}