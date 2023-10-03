class Solution {
    public String removeDuplicates(String s) {
        //  "abbaca"  
        // a   b
        // b   a       remain in the stack ca
        
        Stack<Character> charS = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            //insert the require chars first
            if(!charS.isEmpty()){
                if(charS.peek() != c){
                    charS.push(c);
                }else{
                    charS.pop();
                }
            }else{
                charS.push(c);
            } 
        }
        
        //reamin char in the stack construct the string
         String str = "";
        //剩余的元素即为不重复的元素
        while (!charS.isEmpty()) {
            str = charS.pop() + str;
        }
        return str;
    }
}