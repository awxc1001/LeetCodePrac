class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int left = 0;
        int right = 0;
        
        int maxLen = 0;
        int zeroCount =0;

        while(right < nums.length){
            if(nums[right] == 0){
                zeroCount++;
            }
            right++;

            while(zeroCount > k){
                if(nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
