class Solution {
    public int[] searchRange(int[] nums, int target) {
        //First and Last Position of Element in Sorted Array
        //leftest and rightest using binary search
        
        //dont forget the empty array 
        if(nums.length == 0){
            return new int[]{-1,-1};
        }

        return new int[]{leftNum(nums,target), rightNum(nums,target)};
    }
    
    public int leftNum(int[] nums, int target){
         
        //two pointers binary
        int L = 0;
        int R = nums.length - 1;
        
        //initial check if the value actual exisit, so no over boundry
        if (target < nums[L] || target > nums[R]) {
            return -1;
          }
        
        while(L <= R){
            int mid = L+(R-L)/2;
            //keep shift the range to left
            if( nums[mid] == target){
                R = mid-1;
            }else if( nums[mid] > target ){
                R = mid-1;
            }else if( nums[mid] < target ){
                L = mid+1;
            }
        }
//eventually the condition stops after check L=R, we then check if L contains the correct
        // R is mid-1 after the loop;

        
        if(nums[L] == target){
            return L;
        }
        
        return -1;
    }
    
    public int rightNum(int[] nums, int target){
        
        //two pointers binary
        int L = 0;
        int R = nums.length - 1;
        
        //initial check if the value actual exisit, so no over boundry
        if (target < nums[L] || target > nums[R]) {
            return -1;
          }
        
        while(L <= R){
            int mid = L+(R-L)/2;
            //keep shift the range to right
            if( nums[mid] == target){
                L = mid+1;
            }else if( nums[mid] > target ){
                R = mid-1;
            }else if( nums[mid] < target ){
                L = mid+1;
            }
        }
        
        //eventually the condition stops after check L=R, we then check if R contains the correct
        // L is mid+1 after the loop;
        if(nums[R] == target){
            return R;
        }
        
        return -1;
    }
    
    
}