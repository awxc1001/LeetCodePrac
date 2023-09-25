class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        //use two set to check unique number appearnce
        Set<Integer> set1 = new HashSet<>();
        //result set to record same number occured
        Set<Integer> resSet = new HashSet<>();
        
        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        
        for(int i: nums2){
            if(set1.contains(i)){
                resSet.add(i);
            }
        }
        
        //conver result set to array
        int[] arr = new int[resSet.size()];
        // for(int i = 0; i < reset.size(); i++){
        //     arr[i] = 
        // }
        int index= 0;
        for(int i: resSet){
            arr[index++] = i;
        }
        
        return arr;
    }
}