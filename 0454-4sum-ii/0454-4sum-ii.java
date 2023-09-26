class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        //arrays all of length n
        //only return the counts
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        int total = 0;
        
        //条件是，nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
        //没有target val
        
        //get sum of first two arrays
        for(int i: nums1){
            for(int j: nums2){
                //n^2 time complex, store each pair as sum into the table
                int sum = i + j;
                sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
            }
        }
        
     //如果从nums1和nums2中有2种方式可以得到和为x
    // 同时从nums3和nums4中有1种方式可以得到和为-x
    // 那么，结合这两部分，我们就有2 * 1 = 2种方式使得从这四个数组中选取的数字之和为0。

    // 这就是为什么当我们在nums3和nums4中得到一种特定的两数之和时，我们会乘以哈希映射中存储的相    对应的值（表示从nums1和nums2得到的互补和的次数）。
        
        //check the reamin two arrays to see if their pair sum 
        //match reversely!
        for(int i : nums3){
            for(int j : nums4){
                int reverseSum = -(i+j);
                //get one matched reverSum, we added the previous sum count
                //because that is how many combinations can be made
                total += sumMap.getOrDefault(reverseSum,0);       
            }
        }
        
        return total;   
    }
}