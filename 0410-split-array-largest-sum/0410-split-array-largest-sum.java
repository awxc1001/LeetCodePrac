class Solution {
    public int splitArray(int[] nums, int k) {
        
       int left = 0;
        int right = 0;
        for (int w : nums) {
            left = Math.max(left, w);
            right += w;
        }

        while (left <= right) {
            
            int mid = left + (right - left) / 2;
            if (f( nums, mid) == k) {
                // 搜索左侧边界，则需要收缩右侧边界
                right = mid -1;
            } else if (f( nums, mid) < k) {
                // 需要让 f(x) 的返回值大一些
                right = mid -1;
            } else if (f( nums, mid) > k) {
                // 需要让 f(x) 的返回值小一些
                left = mid + 1;
            }
        }

        return left;
        
    }
    
 public int f(int[] weights, int x) {
    int days = 0;
    for (int i = 0; i < weights.length; ) {
        // 尽可能多装货物
        int cap = x;
        while (i < weights.length) {
            if (cap < weights[i]) break;
            else cap -= weights[i];
            i++;
        }
        days++;
    }
    return days;
}
}