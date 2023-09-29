class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //any order, so we can sort first then recursive call
        Arrays.sort(nums);
        //numbers代表要几个数的和，不是array里几个数字
        int numbers = 4;
        int startP = 0;
        return nTargetSum(nums, numbers, startP, target);
    }
    
    //}测试用例:[1000000000,1000000000,1000000000,1000000000] -294967296
// 测试结果:[[1000000000,1000000000,1000000000,1000000000]]
// 期望结果:[]
// 是因为target – nums[i]负向超出了int的数值范围，会从int最大值重新开始计算，继续往下递归。相当于4个1000000000两两抵消了，最后结果与-294967296还是相等。
// 此时只需要把nSumTarget传入的参数target的数据类型从int改为long即可通过全部用例。
    public List<List<Integer>> nTargetSum(int[] nums, int numbers, int startP, long target){
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length; //size和numbers不是一个意思
        //base case, from two sum then stacking
        if(numbers < 2 || size < numbers) return result;
        if(numbers == 2){//要找两数之和的时候
            //常规双指针搜索整个array
            int left = startP;//指针应该是startP，保证不选多个
            int right = size - 1;
            while(left < right){
                int sum = nums[left] + nums[right];
                int low = nums[left];
                int high = nums[right];
                //shift both left and right
                if(sum < target){
                    left++;
                }else if (sum > target){
                    right--;
                }
                //add unique pair only
                else if(sum == target){    
                    // Use low and high
                List<Integer> tempList = new ArrayList<>(Arrays.asList(low, high));  
                result.add(tempList);
                   //shifting, left+1 和 right+1会导致对不准
                   while(left < right && nums[left] == low){
                       left++;
                   }
                   while(left < right && nums[right] == high){
                       right--;
                   }
                }
            }
        }else{ //if more than 2 numbers
            for(int i = startP; i < size; i++){
                //递归调用每个答案然后拼接
            
                long required = target - nums[i];
                int searchIndex = i+1;
                List<List<Integer>> answers = nTargetSum(nums, numbers-1, searchIndex, required);
                 // (n-1)Sum 加上 nums[i] 就是 nSum
                for(List<Integer> answer: answers){
                    answer.add(nums[i]);
                    result.add(answer);
                }
                //avoid duplicate
                while(i < size-1 && nums[i] == nums[i+1]){
                    i++;
                }
            }
        }
        return result;
    }
}