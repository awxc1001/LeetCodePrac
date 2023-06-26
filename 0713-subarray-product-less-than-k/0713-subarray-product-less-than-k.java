class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        //window
        int left = 0;
        int right = 0;
        int windowPro = 1;
        //record valid ones
        int validCount = 0;
        
        while(right < nums.length){
            //increase the window product
            //element itself also counts as a subarray that have product less than K
            windowPro *= nums[right];
            right++;
            
            //shrink when the window pro bigger or equal than K
            while(left<right && windowPro >= k){
                windowPro /= nums[left];
                left++;
            }
            
           // 现在必然是一个合法的窗口，但注意思考这个窗口中的子数组个数怎么计算：
            // 比方说 left = 1, right = 4 划定了 [1, 2, 3] 这个窗口（right 是开区间）
            // 但不止 [left..right] 是合法的子数组，[left+1..right], [left+2..right] 等都是合法子数组
            // 所以我们需要把 [3], [2,3], [1,2,3] 这 right - left 个子数组都加上
            validCount += right - left;
        }
        return validCount;
    }
}