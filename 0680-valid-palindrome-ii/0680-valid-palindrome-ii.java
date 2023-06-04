class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        
        while(left < right && s.charAt(left) == s.charAt(right)){
            left ++;
            right --;
        }
        if(left == right){
            return true;
        }
        if( isPali(s,left+1,right) || isPali(s, left, right-1)){
            return true;
        }
        return false;
    }
    
    public boolean isPali(String s, int left, int right){
        
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }
}