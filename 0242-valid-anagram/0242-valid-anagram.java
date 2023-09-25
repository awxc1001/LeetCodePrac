class Solution {
    public boolean isAnagram(String s, String t) {
        
        // array hashmapping
        int[] records = new int[26];
        
        //++和--是增加和减少字母计数的操作。
        for(int i = 0; i < s.length(); i++){
            records[s.charAt(i) - 'a'] ++;
        }
        
        for(int i = 0; i < t.length(); i++){
            records[t.charAt(i) - 'a'] --;
        }
        
        for(int record: records){
            if(record !=0){
            return false;
            }
        }
        
        return true;
    }
}