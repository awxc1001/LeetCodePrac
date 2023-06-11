class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stk = new Stack<>();
        
        for(String token: tokens){
            if("+-*/".contains(token)){
                
                //grab two numbers from top of the stack, last int first out
                int a = stk.pop(); 
                int b = stk.pop();
                
                //last in first out, so b-a and b/a b is the first number
                switch(token){
                    case "+":
                        stk.push(b+a);
                        break;
                    case "-":
                        stk.push(b-a);
                        break;
                    case "*":
                        stk.push(b*a);
                        break;
                    case "/":
                        stk.push(b/a);
                        break;    
                }
            }
            else{
                //number just push in, can add if
                stk.push(Integer.parseInt(token));
            }
        }
        //last number in the stack is the answer
        return stk.pop();
    }
}