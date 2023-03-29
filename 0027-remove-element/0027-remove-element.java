class Solution {
    public int removeElement(int[] nums, int val) {
        
    // 0 <= nums.length <= 100
    // 0 <= nums[i] <= 50
    // 0 <= val <= 100
        if(nums.length == 0){
            return 0;
        }
        
        int fp =0, sp =0;
        // fp just move by itself by one no matter what
        while(fp < nums.length ){
            
            //if required value is not same
            if(nums[fp] != val){
                //change the array with slowp
                nums[sp] = nums[fp];
                sp ++;
            }
            fp ++;
        }
        //since sp already ++
        return sp;
    }
}