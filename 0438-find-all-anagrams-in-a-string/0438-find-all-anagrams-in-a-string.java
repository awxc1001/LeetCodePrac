class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        //anagram can simply be treated as char count map
        Map<Character, Integer> required = new HashMap<>();
        Map<Character, Integer> window  = new HashMap<>();
        //pop all the characters with counts into the required map based on string p
        for(char c: p.toCharArray()){
            required.put(c,required.getOrDefault(c,0)+1);
        }
        
        //now we can slide window with two pointers
        int left = 0;
        int right = 0;
        
        //validcount for verifying if pair in the window can cover required
        int validCount = 0;
        //A result list to record each starting index
        ArrayList<Integer> res = new ArrayList<>();
        
        //enlarge the window to right till the end
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            //if it is in the required map, put into the window
            if(required.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                //if the count in window macthed in the required map for this char
                //increase a valid count
                if(required.get(c).equals(window.get(c))){
                    validCount++;
                }
            }
            //meanwhile we shrink the window if the it goes over the size of p
            while(right-left >= p.length()){
        //if validCount covers the size of the required map, record the starting index
                if(validCount == required.size()){
                    res.add(left);
                }
                
                //meanwhile remove the chars from the window
                char del = s.charAt(left);
                left++;
                
                //if exisit in required, update the window and ValidCount depends
                if(required.containsKey(del)){
                    //reduce valid if it is reduced below the count
                    if(required.get(del).equals(window.get(del))){
                        validCount--;
                    }
                    //reduce window always
                    window.put(del,window.get(del)-1);
                }
            }
        }
        return res;
    }
}