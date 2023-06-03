class Solution {
    public int search(int[] nums, int target) {
        
        //two pointers
        int left = 0;
        int right = nums.length -1;
        
        while(left <= right){ // <= will scan the middle one as well
            
            //get mid, avoid over stacking
            int mid = left+ (right - left);
            //compare, remember use nums, mid is just index
            if( nums[mid] == target){
                return mid;
            }else if( nums[mid] < target ){
                //too small move left to righter region
                left = mid+1;
            }else if( nums[mid] > target){
                //too big move right to lefter region
                right = mid-1;
            }
            
        }
        
        //nothing found return -1;
        return -1;
        
    }
}