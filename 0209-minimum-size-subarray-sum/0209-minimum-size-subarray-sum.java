class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int left = 0, right = 0;
        // 维护窗口内元素之和
        int windowSum = 0;
        int resLen = Integer.MAX_VALUE;
        
        for(;right<nums.length; right++){
            //enlarge
            windowSum += nums[right];
            //注意我们要一直移动left缩小窗口until satisy, 所以while
            while(windowSum >= target){ //shrinking condition
                //update resLen before shrink so minum is recorded
                //要加1因为left和right从0开始
                resLen = Math.min(resLen, right-left+1);
                //shrink window
                windowSum -= nums[left++];
            }
        }
        //dont forgot return 0 if no change
        return resLen == Integer.MAX_VALUE ? 0 : resLen;
    }
}