class Solution {
    public void moveZeroes(int[] nums) {
        
       int zeroStartingIndex = removeZeroes(nums);
       
        for(; zeroStartingIndex < nums.length; zeroStartingIndex++ ){
            nums[zeroStartingIndex] =0;
        }
        
}
    
    
    
    public int removeZeroes(int[] nums) {
        
        int fp =0, sp =0;
        
        // < not <=
        while( fp < nums.length){
            
            if( nums[fp] != 0 ) {
                nums[sp] = nums[fp];
                sp++;    
            }
            
            fp++;
        }
        
        // sp is now at changedindex+1, since every change sp++
        return sp;
    }
        
       
}
    
     