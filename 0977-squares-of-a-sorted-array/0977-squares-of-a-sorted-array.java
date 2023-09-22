class Solution {
    public int[] sortedSquares(int[] nums) {
        
        //non-decreasing order, so biggest squre must be on the edges
        //so we can use double pointer using left and right
        int left = 0;
        int right = nums.length-1;

        //new array
        int[] res = new int[nums.length];
        //non-decreasing order, put the biggeer number at the end
        int cur = res.length-1;

        while(left <= right){
            //since its square number, abs value will do as well
            if(Math.abs(nums[right]) > Math.abs(nums[left])){
                //place in non-decrease order, so bigger one goes to the end of res
                //remember is square number
                res[cur] = nums[right]*nums[right];
                //shifting 
                cur--;
                right--;
            }else{
                res[cur] = nums[left]*nums[left];
                cur--;
                left++;
            }
     
        }
         return res;   
    }
}