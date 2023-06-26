class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] charCountWindow = new int[26];
        
        int left =0;
        int right =0;
        
        int maxCount =0;
        int maxLen = Integer.MIN_VALUE;
        int changeCount =0;
        
        while(right < s.length()){
            //since we dont know the maxAppearChar beforehand, we need to update it
            //when enlarging the window
            
            //record and count the max
            charCountWindow[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount,charCountWindow[s.charAt(right)-'A']);
            right++;
            
            while(right-left-maxCount >k){
                charCountWindow[s.charAt(left) - 'A']--;
                left++;
            }
           
            maxLen = Math.max(maxLen, right-left);
        }
        
        return maxLen;
    }
}