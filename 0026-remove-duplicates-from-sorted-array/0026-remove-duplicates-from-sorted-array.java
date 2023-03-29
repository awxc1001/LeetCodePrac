class Solution {
    public int removeDuplicates(int[] nums) {
        
        int fp = 0;
        int sp = 0;
        if(nums.length == 0 || nums == null){
            return 0;
        }
        //fast move by it self based on length
        while( fp < nums.length ){
            
            //slow should only foward if fast index show different element
            if(nums[fp] != nums[sp]){
                int unique = nums[fp];
                sp ++;
                nums[sp] = unique;
            }
            //no matter what fast will move by one till the end
            fp ++;
        }
        // number of unique should be slow+1 given start at index 0;
        return sp+1;
    }
}