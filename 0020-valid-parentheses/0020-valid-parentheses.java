class Solution {
    public boolean isValid(String s) {
        Stack<Character> left= new Stack<>();
        //outest left char match for outest right char, can only be done using stack

        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                left.push(c);
            }else{ //not these left char then match
                //use peek to compare, otherwise if pop, element lost
                 if(!left.isEmpty() && LeftChar(c) == left.peek()){
                     //only match, then pop 
                     left.pop();
                 }else{
                     //return false if immediate fail
                     return false;
                 }
            }
        }
        //check if all left been matched
        return left.isEmpty();
    }
    
    public Character LeftChar(Character c){
        if(c == ')') return '(';
        if(c == '}') return '{';
        return '[';
    }
}