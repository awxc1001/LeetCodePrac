class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> stk = new Stack<>();
        
        for(String token: tokens){
            if("+-*/".contains(token)){
                
                int a = stk.pop(); 
                int b = stk.pop();
                
                switch(token){
                    case "+":
                        stk.push(a+b);
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
                stk.push(Integer.parseInt(token));
            }
        }
        
        return stk.pop();
    }
}