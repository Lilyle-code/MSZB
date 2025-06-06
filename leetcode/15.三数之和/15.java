class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1, right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] +nums[right];
                if(sum > 0 ) right--;
                else if(sum < 0) left++;
                else{
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[right] == nums[right-1]) right--;
                    while(left < right && nums[left] == nums[left+1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}