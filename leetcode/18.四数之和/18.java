class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && nums[i] > target) break;
            if(i > 0 && nums[i - 1] == nums[i]) continue;
            long t1 = target -nums[i];
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] > 0 && nums[j] > t1) break;
                if(j > i + 1 && nums[j - 1] == nums[j]) continue;
                int left = j + 1, right = nums.length - 1;
                while(left < right){
                    long cursum = (long)nums[j] + nums[left] + nums[right];
                    if(cursum > t1) right--;
                    else if(cursum < t1) left++;
                    else{
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[right] == nums[right - 1]) right--;
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return res;
    }
}