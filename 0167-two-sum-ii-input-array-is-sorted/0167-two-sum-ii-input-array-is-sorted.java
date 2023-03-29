class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        //start with one index on start, one index on tail
        int L = 0;
        int R = numbers.length-1;
        
        //2 <= numbers.length <= 3 * 104
        //You may not use the same element twice.
        //there is exactly one solution
        
        
        //from smallest to largest sorted array
        while(L < R){
            int sum = numbers[L] + numbers[R];
            if( sum == target){
                //Let these two numbers be numbers[index1] and numbers[index2]
                //where 1 <=index1 < index2 <= numbers.length. index start from 1 not zero
                return new int[]{L+1, R +1};
            }else if(sum < target){ // test with a bigger left
            L++;
        }else if(sum > target){ // test with a smaller right
            R--; 
        }
    }
        // if nothing matched!
        return new int[]{0,0};
}

}