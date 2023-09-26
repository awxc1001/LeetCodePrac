class Solution {
    public boolean isHappy(int n) {
        
        Set<Integer> sumRecord = new HashSet<>();
        //1 <= n <= 231 - 1
        
        //cotains说明endless loop, can quit
        while(n != 1 && !sumRecord.contains(n)){
            sumRecord.add(n);
            n = getNextSum(n);
        }
        
        return n ==1;
    }
    
    public int getNextSum(int n){
         //record result
         int res = 0;
         //each digit times processing
        while(n > 0){
           //while (n > 0) {: 只要 n 是正数，这个循环就会继续。每次循环，我们都会处理 n 的最后一个数字，然后将其去除。

// int temp = n % 10;: 使用模运算符 %，我们可以得到 n 的最后一个数字。例如，如果 n 是 123，则 temp 将是 3。

// res += temp * temp;: 这里，我们将 temp（即 n 的最后一个数字）进行平方，并将结果累加到 res 上。

// n = n / 10;: 这个操作将 n 的最后一个数字去除。继续上面的例子，如果 n 是 123，那么这行代码执行后 n 将变为 12。 
           int temp = n % 10;
           res += temp * temp;
           n /=10; 
            
        }
        return res;
    }
}