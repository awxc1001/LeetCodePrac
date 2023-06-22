class Solution {
    public int searchInsert(int[] nums, int target) {
        //1 <= nums.length <= 104
        int L = 0;
        int R = nums.length-1;
        
        //binary search on the either the target or the most left insert index 
        while(L <= R){
            int mid = L + (R-L) /2;
            //if value found
            if( target == nums[mid] ){
                return mid;
            }else if(target > nums[mid]){//too big, locate the righter region
                L = mid +1;
            }else if(target < nums[mid]){ 
                //smaller than mid, means can be insert
                //we lock the region to the left, and search on the most left
                R = mid-1;
            }
        }
        return L;
    }
    
    
}