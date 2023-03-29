class Solution {
    public void reverseString(char[] s) {
        
        // left right indexes
        int L = 0, R = s.length-1;
        
        while( L < R){ // no need to swap the middle one
            
            //simple swap, dont forget spelling!
            char temp = s[L];
            s[L] = s[R];
            s[R] = temp;
            
            //move two pinter at the same time, logn
            L++;
            R--;
        }
    }
}