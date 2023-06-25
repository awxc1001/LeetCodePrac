class Solution {
    public int lengthOfLongestSubstring(String s) {
        //only one String given, find its longest unique char substring
        
        //use a window map to record the char count of s
        Map<Character, Integer> window = new HashMap<>();
        
        //starting pointers
        int left =0;
        int right =0;
        
        int res = 0;
        
        while(right < s.length()){
            //record the char and put count into the window
            char c = s.charAt(right);
            right++;
            
            window.put(c,window.getOrDefault(c,0)+1);
            
            //we reduce the window if any count of char goes above 1
            while(window.get(c) > 1){
                //this loop will keepgoing until the this sepcific char Count reaches 1
                char del = s.charAt(left);
                left++;
                window.put(del,window.get(del)-1);
            }
            
            //record the longest subString sizze after shirnking ends, because now there is 
            //no duplicate
            res = Math.max(res,right-left);
        }
        
        
        return res;
    }
}