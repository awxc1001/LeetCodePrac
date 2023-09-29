class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        return threeSumTarget(nums, 0);
    }
    
    public List<List<Integer>> twoSumTarget(int[] nums,int startPosition, int target) {
        //assume array already sorted
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int left = startPosition;
        int right = n-1;
        while(left < right){
            int sum = nums[left] + nums[right];
            
            //record the orignal answer because need to check if duplicate
            int low = nums[left];
            int high = nums[right];
            //too small or too big
            if(sum < target){
                left++;
            }else if(sum > target){
                right--;
            }else{
                //valid value added and need to avoid duplicate
                // make sure use wrapper clase, because Integer 
                Integer[] array = {nums[left],nums[right]};
                result.add(Arrays.asList(array));
                
                //keep shifting with no duplicate answer
                //ensure no ArrayOutofBoundry Exception
                
                //不能写成nums[left+1]和nums[right-1]因为他们会自己移动导致不是原来的
                //low和high记录了保证一直是那个对的left和right值
                while(left < right && nums[left] == low){
                    left++;
                }
                while(left < right && nums[right] == high){
                    right--;
                }
            }
        }
        return result;
    }
    
    
    public List<List<Integer>> threeSumTarget(int[] nums, int target) {
        
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            //target answer after remove the current val
            int required = target-nums[i];
            
            //grab the all the two sum list based on the required value
            //i+1因为我们要从其他数字开始检查，从开始到最右边
            List<List<Integer>> twoSums = twoSumTarget(nums,i+1,required);
            //if there is a match we add the the current value
            for(List<Integer> answer: twoSums){
             List<Integer> triplet = new ArrayList<>(answer); // 创建一个新的列表
             triplet.add(nums[i]); // 添加当前数字到新的列表
             result.add(triplet); // 将新的列表添加到结果中
            }
            //avoid duplicate, keep shifting pointer to the unique value
            while(i < n-1 && nums[i] == nums[i+1]){
                i++;
            }
        }
        return result;
    }
}