class Solution {
    public boolean isValid(String s) {
        
        //use Stack, first in last out
        Stack<Character> lefts = new Stack<>();
        
        for(char c: s.toCharArray() ){
            if(c == '(' || c == '[' || c == '{'){
                lefts.push(c);
            }else{ 
            // consider case with only one right ]
                if( !lefts.isEmpty() && leftChar(c) == lefts.peek()  ){
                    lefts.pop();
                }else{
                    return false;
                }
            }
        }
        //make sure all lefts are out
        return lefts.isEmpty();
    }
    
    public char leftChar (char right){
        if(right == ')') return '('; 
        if(right == ']') return '['; 
         return '{'; 
    }
}