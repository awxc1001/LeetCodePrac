class Solution {
    public int[] twoSum(int[] nums, int target) {
        //two sum use hashmap
        HashMap<Integer,Integer> numMap= new HashMap<>();
        
        //record num and index
        for(int i = 0; i < nums.length; i++){
            //checkmap to see if a needed num is in the map
            int need = target - nums[i];
            //this way we loop, the index wont be missed
            //make sure you know which one is the key
            if(numMap.containsKey(need)){
                return new int[]{numMap.get(need),i};
            }
            //store in map
            numMap.put(nums[i],i);
        }
        return null;
    }
}